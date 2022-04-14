package solutions.array;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray697 {
    /*
    Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
Note:
nums.length will be between 1 and 50,000.
nums[i] will be an integer between 0 and 49,999.
     */

    public int findShortestSubArray(int[] nums) {
        Map<Integer,Integer> firstIdx  = new HashMap<>() , freq = new HashMap<>();
        int ans = 0, degree = 0;
        for(int i=0;i<nums.length;i++){
            firstIdx.putIfAbsent(nums[i],i);
            freq.put(nums[i],freq.getOrDefault(nums[i],0)+1);
            if(freq.get(nums[i])>degree){
                degree = freq.get(nums[i]);
                ans = i - firstIdx.get(nums[i]) + 1;
            }else if(freq.get(nums[i])==degree){
                ans = Math.min(ans,i-firstIdx.get(nums[i])+1);
            }
        }
        return ans;
    }

}
