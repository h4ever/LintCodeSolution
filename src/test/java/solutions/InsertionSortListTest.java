package solutions;

import solutions.InsertionSortList;
import structure.ListNode;
import org.junit.Test;

public class InsertionSortListTest {

	@Test
	public void testInsertionSortList() {
		InsertionSortList testInstance  = new InsertionSortList();
		ListNode head = ListNode.generateList("12->10->0->3->87->22->6->4->3->3->2->1->null");
		ListNode sortedList = testInstance.insertionSortList(head);
		System.out.println(sortedList);
		System.out.println(head);
		
	}
	
	@Test
	public void testInsertionSortList2() {
		InsertionSortList testInstance  = new InsertionSortList();
		ListNode head = ListNode.generateList("12->10->0->3->87->22->6->4->3->3->2->1->null");
		ListNode sortedList = testInstance.insertionSortList2(head);
		System.out.println(sortedList);
		System.out.println(head);
		
	}

}
