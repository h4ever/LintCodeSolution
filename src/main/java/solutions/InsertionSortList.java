package solutions;

import structure.ListNode;

public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		ListNode helper = new ListNode(0);
		ListNode pre = helper;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			while (pre.next != null && pre.next.val < head.val) {
				pre = pre.next;
			}
			head.next = pre.next;
			pre.next = head;
			pre = helper;
			head = next;
		}
		return helper.next;
	}
	
	public ListNode insertionSortList2(ListNode head) {
		ListNode helper = new ListNode(0);
		ListNode pre = helper;
		ListNode next = null;
		while (head != null) {
			next = head.next;
			
			if(pre.val>head.val) pre = helper;
			
			while (pre.next != null && pre.next.val < head.val) {
				pre = pre.next;
			}
			
			head.next = pre.next;
			pre.next = head;
			
			head = next;
		}
		return helper.next;
	}
	
}
