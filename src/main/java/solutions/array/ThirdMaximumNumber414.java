package solutions.array;

import java.util.PriorityQueue;
import java.util.Queue;

public class ThirdMaximumNumber414 {
    /*
    Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
     */
    public static final int TOPN = 3;
    public int thirdMax(int[] nums) {
        Queue<Integer> top3 = new PriorityQueue<>(TOPN+1);
        for(int num:nums){
            if(!top3.contains(num)){
                top3.offer(num);
            }
            if(top3.size()>TOPN){
                top3.poll();
            }
        }
        if(top3.size()<TOPN){
            while(top3.size()>1) top3.poll();
        }
        return top3.peek();
    }

    public int thirdMax2(int[] nums) {
        Integer max1=null,max2=null,max3=null;
        for(Integer num:nums){
            if(num.equals(max1)||num.equals(max2)||num.equals(max3)) continue;
            if(max1 == null||num>max1){
                max3=max2;
                max2=max1;
                max1=num;
            }else if(max2==null||num>max2){
                max3=max2;
                max2=num;
            }else if(max3==null||num>max3){
                max3=num;
            }
        }
        return max3==null?max1:max3;
    }
}
