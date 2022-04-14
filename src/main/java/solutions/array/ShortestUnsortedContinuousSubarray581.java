package solutions.array;


public class ShortestUnsortedContinuousSubarray581{
    /*
    Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.
Note:

    Then length of the input array is in range [1, 10,000].
    The input array may contain duplicates, so ascending order here means <=.

     */
    public static int findUnsortedSubarray(int[] nums) {
        if(nums.length<2) return 0;
        if(nums[0]>nums[nums.length-1]) return nums.length;

        int l=-1,r=-2,min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            if(nums[i]<max) r=i;
        }
        for(int i=nums.length-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            if(nums[i]>min) l=i;
        }
        return r-l+1;
    }
}
