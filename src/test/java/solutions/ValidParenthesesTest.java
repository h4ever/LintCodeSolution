package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.solutions.ValidParentheses;

public class ValidParenthesesTest {

	private static ValidParentheses test;
	
	@Before
	public void setUp() throws Exception {
		test = new ValidParentheses();
	}

	@Test
	public void testIsValid() {
		Assert.assertTrue(test.isValid("({[]}[{}]{})"));
		assertTrue(!test.isValid("{}{}{}{}{]]]]"));
		assertTrue(!test.isValid("{}{}{}{(}{)}"));
	}

}
