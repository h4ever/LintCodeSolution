package solutions;

import solutions.PlusOne66;
import org.junit.Test;

public class PlusOne66Test {

	@Test
	public void testPlusOne() {
		PlusOne66 testInstance = new PlusOne66();
		int[] input = {9,8,9,9};
		int[] output = testInstance.plusOne(input);
		System.out.print("{");
		for(int i=0;i<output.length-1;i++){
			System.out.print(output[i]+",");
		}
		System.out.print(output[output.length-1]);
		System.out.println("}");
	}

}
