package solutions.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII219 {
    /*
    Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> indices = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(indices.containsKey(nums[i])){
                if(i-indices.get(nums[i])<=k) return true;
            }
            indices.put(nums[i],i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> tool = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(i>k) tool.remove(nums[i-k-1]);
            if(!tool.add(nums[i])) return true;
        }
        return false;
    }
}
