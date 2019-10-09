package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.Sqrt69;

public class Sqrt69Test {

	@Test
	public void testMySqrt() {
		Sqrt69 testInstance = new Sqrt69();
		assertEquals(testInstance.mySqrt(4),2);
		assertEquals(testInstance.mySqrt(8),2);
		assertEquals(testInstance.mySqrt(2147395600),46340);
	}

}
