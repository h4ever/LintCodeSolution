package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.AddBinary67;

public class AddBinary67Test {

	@Test
	public void testAddBinary() {
		AddBinary67 testInstance = new AddBinary67();
		System.out.println(testInstance.addBinary("10011", "1011"));
	}

}
