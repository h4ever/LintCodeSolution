package solutions.array;

public class NondecreasingArray665 {
    /*
    Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
     */
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int p=1;p<nums.length&&cnt<=1;p++){
            if(nums[p-1]>nums[p]){
                cnt++;
                if(p-2<0||nums[p-2]<nums[p]) nums[p-1]=nums[p];
                else nums[p] = nums[p-1];
            }
        }
        return cnt<=1;
    }
}
