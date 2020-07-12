package test.java.solutions;

import main.java.solutions.Sqrt69;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Sqrt69Test {

	@Test
	public void testMySqrt() {
		Sqrt69 testInstance = new Sqrt69();
		assertEquals(testInstance.mySqrt(4),2);
		assertEquals(testInstance.mySqrt(8),2);
		assertEquals(testInstance.mySqrt(2147395600),46340);
	}

}
