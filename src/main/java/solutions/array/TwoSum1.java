package main.java.solutions.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

     */
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer,Integer> indxInfo = new HashMap<>();
        indxInfo.put(nums[0],0);
        for(int i=1;i<nums.length;i++){
            if(indxInfo.containsKey(target-nums[i])){
                ans[0]=indxInfo.get(target-nums[i]);
                ans[1] = i;
            }
            indxInfo.put(nums[i],i);
        }
        return ans;
    }

}
