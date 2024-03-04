package solutions.carl.list;

import structure.ListNode;

public class CycleInLinkedList142 {
    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;

        while(fast!=null&& fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                break;
            }
        }
        if(fast==null||fast.next==null) return null;

        ListNode p = head;
        while(p!=slow){
            p = p.next;
            slow = slow.next;
        }
        return slow;


    }
}
