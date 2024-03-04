package solutions.carl.list;

import structure.ListNode;

public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null||head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pr = dummy, p = head ;

        while(p != null && p.next!=null){
            ListNode l = p;
            ListNode r = p.next;

            pr.next = r;
            l.next = r.next;
            r.next = l;

            pr = l;
            p = l.next;
        }
        return dummy.next;
    }


}
