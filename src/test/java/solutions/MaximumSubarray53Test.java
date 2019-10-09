package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.MaximumSubarray53;

public class MaximumSubarray53Test {

	@Test
	public void testMaxSubArray() {
		MaximumSubarray53 testInstance = new MaximumSubarray53();
		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		assertEquals(testInstance.maxSubArray(array),6);
	}
	
	@Test
	public void testMaxSubArrayDP() {
		MaximumSubarray53 testInstance = new MaximumSubarray53();
		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		assertEquals(testInstance.maxSubArrayDP(array),6);
	}

}
