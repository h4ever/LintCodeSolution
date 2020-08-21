package main.java.solutions.array;

public class RemoveDuplicatesFromSortedArray26 {
    /*
    Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0;
        int j=0;
        for (int i=0; i<nums.length; i++)
            if (nums[i]!=nums[j]) nums[++j]=nums[i];
        return ++j;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length<2) return nums.length;
        int j=1;
        for (int i=0; i<nums.length; i++)
            if (nums[i]!=nums[j-1]) {
                nums[j++] = nums[i];
            }
        return j;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,4,4};
        removeDuplicates2(nums);

    }
}
