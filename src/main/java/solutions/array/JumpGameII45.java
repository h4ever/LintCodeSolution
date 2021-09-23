package main.java.solutions.array;

public class JumpGameII45 {
    public static int jump(int[] nums) {
        if(nums.length<=1) return 0;
        int jumps = 0, curEnd = 0, curFathest = 0;
        for(int i=0;i<nums.length-1;i++){
            curFathest=Math.max(curFathest,i+nums[i]);
            if(i>curFathest) return -1;
            if(i==curEnd){
                jumps++;
                curEnd=curFathest;
            }
        }
        return jumps;

    }



    public static void main(String[] args) {
        int[] nums = {1,2,0,0,0};
        int x = jump(nums);
        System.out.println(x);
    }
}
