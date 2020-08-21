package main.java.solutions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference1200 {
    /*
    Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

    a, b are from arr
    a < b
    b - a equals to the minimum absolute difference of any two elements in arr

     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int diff = arr[i+1]-arr[i];
            if(diff<minDiff){
                minDiff = diff;
                ans.clear();
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }else if(minDiff == diff){
                ans.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return ans;
    }
}
