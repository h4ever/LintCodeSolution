package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.DeleteNodeInALinkedList;
import main.java.structure.ListNode;

public class DeleteNodeInALinkedListTest {

	@Test
	public void testDeleteNode() {
		DeleteNodeInALinkedList testInstance = new DeleteNodeInALinkedList();
		ListNode head = ListNode.generateList("1->2->3->4->5->null");
		ListNode node3=head.next.next;
		testInstance.deleteNode(node3);
		assertEquals(head.toString(),"1->2->4->5->null");
	}

}
