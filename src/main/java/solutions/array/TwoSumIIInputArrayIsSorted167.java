package solutions.array;

public class TwoSumIIInputArrayIsSorted167 {
    /*
    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

    Your returned answers (both index1 and index2) are not zero-based.
    You may assume that each input would have exactly one solution and you may not use the same element twice.

     */
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int l=0,r=numbers.length-1;
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                res[0]=l+1;res[1]=r+1;
                break;
            }else if(numbers[l]+numbers[r]>target){
                r--;
            }else{
                l++;
            }
        }
        return res;
    }
}
