package main.java.solutions;

import main.java.structure.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode helper = new ListNode(0);
		ListNode it = head;
		ListNode pre = helper;
		ListNode next = null;
		while (it != null) {
			next = it.next;
			while (pre.next != null && pre.next.val < it.val) {
				pre = pre.next;
			}
			it.next = pre.next;
			pre.next = it;
			pre = helper;
			it = next;
		}
		return helper.next;
	}
}
