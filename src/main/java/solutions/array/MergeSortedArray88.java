package main.java.solutions.array;

public class MergeSortedArray88 {
	/*
	Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

    The number of elements initialized in nums1 and nums2 are m and n respectively.
    You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

	 */
		public void merge(int[] nums1,int m,int[] nums2,int n){
			int p=m+n-1;
			int i=m-1;int j=n-1;
			while(i>=0&&j>=0){
				if(nums1[i]>=nums2[j]){
					nums1[p--]=nums1[i--];
				}else{
					nums1[p--]=nums2[j--];
				}
			}
			while(j>=0){ //because nums1 is the container ... for the situation : nums1.length < nums2.length
				nums1[p--]=nums2[j--];
			}
		}

		public int[] merge(int[] nums1, int[] nums2){
			int m=nums1.length;
			int n=nums2.length;
			int[] ans = new int[m+n];
			int i=0,j=0,p=0;
			while(p<m+n){
				ans[p++] = nums1[i]<nums2[j]?nums1[i++]:nums2[j++];
			}
			return ans;
		}
}
