package solutions.twopointers;

public class MergeSortedArray88 {
    /*
    Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p=m+n-1,i=m-1,j=n-1;
        while(i>-1&&j>-1){
            if(nums1[i]>nums2[j]){
                nums1[p--]=nums1[i--];
            }else{
                nums1[p--]=nums2[j--];
            }
        }
        while(j>-1) {
            nums1[p--] = nums2[j--];
        }
    }

}
