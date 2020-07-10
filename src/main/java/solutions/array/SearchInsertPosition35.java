package main.java.solutions.array;

public class SearchInsertPosition35 {
    /*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.
     */
    public int searchInsert(int[] nums, int target) {
        int l=0,r=nums.length;
        while(l<r){
            int m = l + (r-l)/2;
            if(nums[m]<target){
                l=m+1;
            }else{
                r = m;
            }
        }
        return l;
    }
}
