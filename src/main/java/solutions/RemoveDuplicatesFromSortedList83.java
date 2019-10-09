package main.java.solutions;

import main.java.structure.ListNode;

public class RemoveDuplicatesFromSortedList83 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode nextNode = head.next;
		ListNode currNode = head;
		while (nextNode != null) {
			if (currNode.val == nextNode.val) {
				currNode.next = nextNode.next;
			} else {
				currNode = nextNode;
			}
			nextNode = nextNode.next;
		}
		return head;
	}

	public ListNode deleteDuplicates1p(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pointer = head;
		while (pointer.next != null) {
			if (pointer.val == pointer.next.val) {
				pointer.next = pointer.next.next;
			}else{
				pointer = pointer.next;
			}
		}
		
		return head;
	}
}
