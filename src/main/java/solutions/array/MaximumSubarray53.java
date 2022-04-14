package solutions.array;

public class MaximumSubarray53 {
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     */
	public int start = 0;
	public int end = 0;
	
	public int maxSubArray(int[] nums) {
        int n = nums.length;
        int maxEndingHere = nums[0];
        int maxSoFar = maxEndingHere;
        for(int i = 1; i < n; i++){
        	maxEndingHere =Math.max(nums[i], maxEndingHere+nums[i]) ;
        	maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
	
	public int maxSubArrayDP(int[] nums) {
		int n = nums.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = nums[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
	
	public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int maxEndingHere = nums[0];
        int maxSoFar = maxEndingHere;
        int temp = 0;
        for(int i = 1; i < n; i++){
        	if(maxEndingHere<0){
        		temp = i;
        		maxEndingHere = nums[i];
        	}else{
        		maxEndingHere += nums[i];
        	}
        	
        	if(maxEndingHere>maxSoFar){
        		start = temp;
        		end  =i;
        		maxSoFar = maxEndingHere;
        	}
        	
        }
        return maxSoFar;
    }
}
