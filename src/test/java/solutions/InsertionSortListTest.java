package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.InsertionSortList;
import main.java.structure.ListNode;

public class InsertionSortListTest {

	@Test
	public void testInsertionSortList() {
		InsertionSortList testInstance  = new InsertionSortList();
		ListNode head = ListNode.generateList("12->10->0->3->87->22->6->4->3->3->2->1->null");
		ListNode sortedList = testInstance.insertionSortList(head);
		System.out.println(sortedList);
	}

}
