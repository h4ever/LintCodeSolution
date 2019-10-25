package test.java.solutions;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import main.java.solutions.MergeSortedArray88;

public class MergeSortedArray88Test {

	@Test
	public void test() {
		MergeSortedArray88 testInstance = new MergeSortedArray88();
		int[] nums1={4,5,6,0,0,0};
		int[] nums2={1,2,3};
		testInstance.merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}

}
