package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.AddTwoNumbers;
import main.java.structure.ListNode;

public class AddTwoNumbersTest {

	@Test
	public void testAddTwoNumbers() {
		ListNode l1=ListNode.generateList("2->3->4->1->null");
		ListNode l2=ListNode.generateList("6->7->8->5->2->null");
		AddTwoNumbers testInstance = new AddTwoNumbers();
		System.out.println(testInstance.addTwoNumbers(l1, l2));
	}

}
