package solutions;

import solutions.RemoveDuplicatesFromSortedList83;
import structure.ListNode;
import org.junit.Test;

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
