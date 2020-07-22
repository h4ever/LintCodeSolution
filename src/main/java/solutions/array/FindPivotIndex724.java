package main.java.solutions.array;

import java.util.Arrays;

public class FindPivotIndex724 {
    /*
    Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
Constraints:

    The length of nums will be in the range [0, 10000].
    Each element nums[i] will be an integer in the range [-1000, 1000].

     */
    public int pivotIndex(int[] nums) {
        if(nums.length==0) return -1;
        int sum = Arrays.stream(nums).sum();
        int left=0;
        for(int i=0;i<nums.length;i++){
            if(left*2==sum-nums[i]){
                return i;
            }
            left+=nums[i];

        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        if(nums.length<=2) return -1;
        int[] pre = nums.clone();
        int[] post = nums.clone();
        for(int i=1;i<nums.length;i++){
            pre[i] += pre[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            post[i] += post[i+1];
        }
        if(post[1]==0) return 0;
        for(int i=1;i<nums.length-1;i++){
            if(pre[i-1]==post[i+1]) return i;
        }
        if(pre[nums.length-2]==0) return nums.length-1;

        return -1;
    }

}
