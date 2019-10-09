package main.java.structure;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	@Override
	public String toString() {
		String format = "";
		ListNode p = this;
		while (p != null) {
			format = format + p.val + "->";
			p = p.next;

		}
		return format + "null";
	}

	public static ListNode generateList(String s) {
		String[] a = s.split("->");
		if (a.length == 0)
			return null;
		ListNode head = new ListNode(Integer.parseInt(a[0]));
		ListNode p = head;
		for (int i = 1; i < a.length; i++) {
			if (a[i].equals("null")) {
				p.next = null;
			} else {
				p.next = new ListNode(Integer.parseInt(a[i]));
				p = p.next;
			}
		}

		return head;
	}
}
