package test.java.solutions.array;

import main.java.solutions.array.MergeSortedArray88;
import org.junit.Test;

import java.util.Arrays;

public class MergeSortedArray88Test {

	@Test
	public void test() {
		MergeSortedArray88 testInstance = new MergeSortedArray88();
		int[] nums1={0,0,0,4,5,6};
		int[] nums2={1,2,3};
		//testInstance.merge(nums1, 3, nums2, 3);
		int[] ans = testInstance.merge(nums1,  nums2);
		System.out.println(Arrays.toString(ans));
	}

}
