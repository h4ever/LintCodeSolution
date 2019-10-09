package main.java.solutions;

import main.java.structure.ListNode;

public class ReverseLinkedList {
	public ListNode reverseLindedList(ListNode head){
		ListNode newHead = null;
		while(head != null){
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		
		return newHead;
	}
}
