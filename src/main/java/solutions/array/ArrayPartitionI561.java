package main.java.solutions.array;

import java.util.Arrays;

public class ArrayPartitionI561 {
    /*
    Given an array of 2n integers, your task is to group these integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
    Note:

    n is a positive integer, which is in the range of [1, 10000].
    All the integers in the array will be in the range of [-10000, 10000].

     */
    public int arrayPairSum(int[] nums) {
        if(nums.length==0||nums.length%2!=0) return 0;
        Arrays.sort(nums);
        int ans = 0;
        for(int i=0;i<nums.length;i+=2){
            ans+=nums[i];
        }
        return ans;
    }
}
