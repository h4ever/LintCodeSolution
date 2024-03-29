package solutions.array;

import solutions.array.MaximumSubarray53;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

	@Test
	public void testMaxSubArray2() {
		MaximumSubarray53 testInstance = new MaximumSubarray53();
		int[] array = {-2,1,-3,4,-1,2,1,-5,4};
		assertEquals(testInstance.maxSubArray2(array),6);
		assertEquals(testInstance.start,3);
		assertEquals(testInstance.end,6);
	}
	
}
