package main.java.solutions.array;

import java.util.HashMap;
import java.util.Map;

public class KdiffPairsInAnArray532 {
    /*
    Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
    Note:

    The pairs (i, j) and (j, i) count as the same pair.
    The length of the array won't exceed 10,000.
    All the integers in the given input belong to the range: [-1e7, 1e7].

     */
    public int findPairs(int[] nums, int k) {
        if(k<0) return 0;
        Map<Integer,Integer> cnt = new HashMap<>();
        for(int num:nums){
            cnt.put(num,cnt.getOrDefault(num,0)+1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> entry:cnt.entrySet()){
            if(k==0){
                if(entry.getValue()>1) ans++;
            }else{
                if(cnt.containsKey(entry.getKey()+k)) ans++;
            }
        }
        return ans;
    }
}
