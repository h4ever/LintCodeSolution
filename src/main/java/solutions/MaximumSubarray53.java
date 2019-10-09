package main.java.solutions;

public class MaximumSubarray53 {
	
	int max=Integer.MIN_VALUE;
	
	public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int max = sum;
        for(int i = 1; i < n; i++){
            sum = nums[i] + (sum > 0 ? sum : 0);
            max = Math.max(max, sum);
        }
        return max;
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
}
