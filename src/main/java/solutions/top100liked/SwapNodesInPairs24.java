package solutions.top100liked;

import structure.ListNode;

public class SwapNodesInPairs24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode sentinal = new ListNode(-1);
        sentinal.next = head;
        ListNode cur = head,pre = sentinal;
        while(cur!=null&&cur.next!=null){
            pre.next = cur.next;
            pre = pre.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }

        return sentinal.next;

    }

    public ListNode swapPairs2(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode sentinal = new ListNode(-1);
        sentinal.next = head;
        ListNode p = head,prev = sentinal;
        while(p!=null&&p.next!=null){
            ListNode l = p;
            ListNode r = p.next;

            prev.next = r;
            l.next = r.next;
            r.next = l;

            prev = l;
            p = l.next;
        }

        return sentinal.next;

    }
}
