package solutions;

import solutions.ValidParentheses;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
