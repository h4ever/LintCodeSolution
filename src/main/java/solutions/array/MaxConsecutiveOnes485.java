package solutions.array;

public class MaxConsecutiveOnes485 {
    /*
    Given a binary array, find the maximum number of consecutive 1s in this array.
    Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000

     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = (n == 0 ? 0 : maxHere + 1));
        return max;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int max=0;
        for(int l=0;l<nums.length;l++){
            if(nums[l]==0){
                continue;
            }
            int r=l;
            while(r+1<nums.length && nums[r+1]==1){
                r++;
            }
            max = Math.max(max,r-l+1);
            l = r+1;
        }
        return max;
    }

}
