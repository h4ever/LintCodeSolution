package solutions;

import structure.ListNode;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode it = head.next;
		ListNode prev = head;

		while (it != null) {
			if (it.val == val) {
				prev.next = it.next;
				it = it.next;
			} else {
				prev = it;
				it = it.next;
			}
		}

		if (head != null && head.val == val){
			head = head.next;
		}
			
		return head;
	}
}
