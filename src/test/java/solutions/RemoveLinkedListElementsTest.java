package test.java.solutions;

import main.java.solutions.RemoveLinkedListElements;
import main.java.structure.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveLinkedListElementsTest {

	@Test
	public void testRemoveElements() {
		RemoveLinkedListElements testInstance = new RemoveLinkedListElements();
		ListNode head=ListNode.generateList("1->3->2->1->1->2->4->1->null");
		head = testInstance.removeElements(head, 1);
		assertEquals(head.toString(),"3->2->2->4->null");
	}

}
