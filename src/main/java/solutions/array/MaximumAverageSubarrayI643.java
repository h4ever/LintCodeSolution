package main.java.solutions.array;

public class MaximumAverageSubarrayI643 {
    /*
    Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
    Note:

    1 <= k <= n <= 30,000.
    Elements of the given array will be in the range [-10,000, 10,000].

     */
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0 ,runSum = 0;
        for(int i=0;i<nums.length;i++){
            if(i<k){
                runSum+=nums[i];
                maxSum = runSum;
            }else{
                runSum += nums[i]-nums[i-k];
                maxSum = Math.max(maxSum,runSum);
            }
        }
        return maxSum/k;

    }
}
