package solutions.carl.array;

public class MinSubArrayLen209 {
    public int minSubArrayLen(int[] nums, int target){
        /*
        给定一个含有 n 个正整数的数组和一个正整数 target 。

找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
         */
        int res =  Integer.MAX_VALUE;
        int sum = 0,j = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            while(sum>=target){
                int l = i-j+1;
                res = Math.min(res,l);
                sum -= nums[j++];
            }
        }
        return res==Integer.MAX_VALUE?0:res;

    }
}
