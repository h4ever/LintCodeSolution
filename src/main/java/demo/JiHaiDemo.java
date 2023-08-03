package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class JiHaiDemo {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        JiHaiDemo demo = new JiHaiDemo();
        demo.mergeJob();
        Thread.sleep(2000);
        List<Future<Result>> futureList = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for(int i=0; i<100; i++){
            final Long orderId= i+100L;
            final Long userId = (long) i;
            Future<Result> future = executorService.submit(() -> {
                countDownLatch.countDown();
                countDownLatch.await(1000,TimeUnit.MILLISECONDS);
                return demo.operate(new UserRequest(orderId, userId, 1));
            });
            futureList.add(future);
        }

        futureList.forEach(future ->{
            try {
                Result result = future.get(300, TimeUnit.MILLISECONDS);
                System.out.println(Thread.currentThread().getName() + "客户端请求响应:"+result);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
            }
        });
    }


    private BlockingQueue<RequestPromise> queue = new LinkedBlockingQueue<>();


    private Integer stock = 6;
    /**
     * 用户库存扣减
     */
    private Result operate(UserRequest userRequest) throws InterruptedException {
        RequestPromise requestPromise = new RequestPromise(userRequest);

        synchronized (requestPromise) {
            boolean enqueueSuccess = queue.offer(requestPromise,100, TimeUnit.MILLISECONDS);
            if(!enqueueSuccess){
                return new Result(false,"系统繁忙");
            }

            requestPromise.wait(200);
            if(requestPromise.getResult()==null){
                return new Result(false,"等待超时");
            }
        }
        return requestPromise.getResult();
    }

    private void mergeJob(){
        new Thread(()->{
            List<RequestPromise> list = new ArrayList<>();
            while(true){
                if(queue.isEmpty()){
                    try {
                        Thread.sleep(10);
                        continue;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.clear();
                int size = queue.size();
                for(int i=0;i<size;i++){
                    list.add(queue.poll());
                }

                System.out.println(Thread.currentThread().getName() +"合并库存扣减："+list);

                int sum = list.stream().mapToInt(e -> e.getUserRequest().getCount()).sum();
                //两种情况
                if(sum <= stock){
                    stock -= sum;
                    //notify user
                    list.forEach(requestPromise->{
                        requestPromise.setResult(new Result(true,"ok"));
                        synchronized(requestPromise){
                            requestPromise.notify();
                        }
                    });
                    continue;
                }

                for(RequestPromise requestPromise:list){
                    int count = requestPromise.getUserRequest().getCount();
                    if(count<=stock){
                        stock-=count;
                        requestPromise.setResult(new Result(true,"ok"));
                    }else{
                        requestPromise.setResult(new Result(false,"库存不足"));
                    }

                    synchronized(requestPromise){
                        requestPromise.notify();
                    }
                }
            }
        },"mergeThread").start();
    }
}

class RequestPromise{

    private UserRequest userRequest;
    private Result result;

    public RequestPromise(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    public UserRequest getUserRequest() {
        return userRequest;
    }

    public void setUserRequest(UserRequest userRequest) {
        this.userRequest = userRequest;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "RequestPromise{" +
                "userRequest=" + userRequest +
                ", result=" + result +
                '}';
    }
}

class Result{
    Boolean success;
    String msg;

    public Result(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

class UserRequest{
    private Long orderid;
    private Long userId;
    private Integer count;

    public UserRequest(Long orderid, Long userId, Integer count) {
        this.orderid = orderid;
        this.userId = userId;
        this.count = count;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "orderid=" + orderid +
                ", userId=" + userId +
                ", count=" + count +
                '}';
    }
}
