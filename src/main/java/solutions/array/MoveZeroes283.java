package main.java.solutions.array;

public class MoveZeroes283 {
    /*
    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.


     */
    public void moveZeroes(int[] nums) {
        int p = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[p++]=nums[i];
            }
        }
        while(p<nums.length){
            nums[p++] = 0;
        }
    }

    //see also RemoveDuplicatesFromSortedArray26  & RemoveElement27
}
