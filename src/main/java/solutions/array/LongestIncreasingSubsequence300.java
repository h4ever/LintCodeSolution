package solutions.array;

import java.util.Arrays;

public class LongestIncreasingSubsequence300 {
    /*
    Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     */

    private static int lengthOfLMS(int[] nums,int len){
        int[] lis = new int[nums.length];
        int[] lds = new int[nums.length];
        int max = 1;
        lengthOfLIS(nums,lis,len);
        lengthOfLDS(nums,lds,len);

        for(int i=0;i<nums.length;i++){
            max = Math.max(max,lis[i]+lds[i]);
        }
        return nums.length-max+1;
    }

    private static void lengthOfLIS(int[] nums,int[] dp,int len) {
        for(int i=0;i<len;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1) ;
                }
            }
        }
    }

    private static void lengthOfLDS(int[] nums,int[] dp,int len) {
        for(int i=len-1;i>=0;i--){
            dp[i]=1;
            for(int j=i+1;j<len;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1) ;
                }
            }
        }
    }


    private static int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int size = -1;
        if(nums.length > 0) {
            tails[++size] = nums[0];
        }
        for(int i=1; i<nums.length; i++) {
            int j = binarySearch(tails, 0, size, nums[i]);
            if(j<=size){
                tails[j] = nums[i];
            }else{
                tails[++size] = nums[i];
            }
        }
        return size+1;
    }


    private static int lengthOfLMS2(int[] nums){
        int max = 1;
        int[] tailsi = new int[nums.length];
        int[] tailsd = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int lis = lengthOfLIS2(nums,tailsi,i);
            int lds = lengthOfLDS2(nums,tailsd,i);
            max = Math.max(max,lis+lds-1);
        }
        System.out.println(max);
        return max;
    }



    private static int lengthOfLIS2(int[] nums,int[] tails,int m) {
        int size = -1;
        if(nums.length > 0) {
            tails[++size] = nums[0];
        }
        for(int i=1; i<m+1; i++) {
            int j = binarySearch(tails, 0, size, nums[i]);
            if(j<=size){
                tails[j] = nums[i];
            }else{
                tails[++size] = nums[i];
            }
        }
        return size+1;
    }

    private static int lengthOfLDS2(int[] nums,int tails[],int m) {
        int size = -1;
        if(nums.length > 0) {
            tails[++size] = nums[m];
        }
        for(int i=m; i<nums.length; i++) {
            int j = binarySearch2(tails, 0, size, nums[i]);
            if(j<=size){
                tails[j] = nums[i];
            }else{
                tails[++size] = nums[i];
            }
        }
        return size+1;
    }

    /**
     二分搜索，返回arr中第一个不小于val的元素索引
     */
    static int binarySearch(int[] arr, int begin, int end, int val){
        while(begin < end){
            int mid = (begin+end)/2;
            if(arr[mid] < val) {
                begin = mid+1;
            }else{
                end = mid;
            }
        }
        return arr[begin]>=val?begin:(begin+1);
    }

    /**
     二分搜索，返回arr中第一个不大于val的元素索引
     */
    static int binarySearch2(int[] arr, int begin, int end, int val){
        while(begin < end){
            int mid = (begin+end)/2;
            if(arr[mid] > val) {
                begin = mid+1;
            }else{
                end = mid;
            }
        }
        return arr[begin]<=val?begin:(begin+1);
    }

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,1,18};
        lengthOfLMS(nums,nums.length);
    }
}
