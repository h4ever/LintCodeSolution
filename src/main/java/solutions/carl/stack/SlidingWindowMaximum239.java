package solutions.carl.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    /*
    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回 滑动窗口中的最大值 。


     */

    class SlidingWindowQueue{
        private Deque<Integer> queue = new ArrayDeque<>();

        public int peek(){
            return queue.peekFirst();
        }

        public void poll(int v){
            if(!queue.isEmpty()&&v==peek()){
                queue.pollFirst();
            }
        }

        public void offer(int v){
            while(!queue.isEmpty()&&queue.peekLast()<v){
                queue.pollLast();
            }
            queue.offerLast(v);
        }

    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        SlidingWindowQueue q = new SlidingWindowQueue();

        for(int i=0;i<k;i++){
            q.offer(nums[i]);
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = q.peek();
        for(int i=k;i<nums.length;i++){
            q.offer(nums[i]);
            q.poll(nums[i-k]);
            ans[i-k+1] = q.peek();
        }

        return  ans;
    }

}
