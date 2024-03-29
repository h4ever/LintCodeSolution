package solutions.carl.list;

import structure.ListNode;

public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head){
        ListNode dummy = new ListNode(0);
        while(head!=null){
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
