package solutions.array;

public class LongestContinuousIncreasingSubsequence674 {
    /*
    Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
    Note: Length of the array will not exceed 10,000.
     */
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int cnt = 1 ,ans = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                cnt++;
            }else{
                ans = Math.max(ans,cnt);
                cnt = 1;
            }
        }
        return Math.max(ans,cnt);
    }
}
