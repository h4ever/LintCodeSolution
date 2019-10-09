package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.RemoveDuplicatesFromSortedList83;
import main.java.structure.ListNode;

public class RemoveDuplicatesFromSortedList83Test {

	@Test
	public void testDeleteDuplicates() {
		ListNode head=ListNode.generateList("1->1->1->2->2->3->4->4->5->6->null");
		RemoveDuplicatesFromSortedList83 testInstance = new RemoveDuplicatesFromSortedList83();
		System.out.println(testInstance.deleteDuplicates(head));
	}
	
	@Test
	public void testDeleteDuplicates1p() {
		ListNode head=ListNode.generateList("1->1->1->2->2->3->4->4->5->6->null");
		RemoveDuplicatesFromSortedList83 testInstance = new RemoveDuplicatesFromSortedList83();
		System.out.println(testInstance.deleteDuplicates1p(head));
	}

}
