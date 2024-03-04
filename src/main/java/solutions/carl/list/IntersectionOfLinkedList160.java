package solutions.carl.list;

import structure.ListNode;

public class IntersectionOfLinkedList160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode pA = headA, pB = headB;

        while(pA!=null){
            pA = pA.next;
            lenA++;
        }
        while(pB!=null){
            pB = pB.next;
            lenB++;
        }

        int diff = Math.abs(lenA-lenB);
        pA = headA;
        pB = headB;
        if(lenA>lenB){
            while(diff-->0) pA = pA.next;
        }else{
            while(diff-->0) pB = pB.next;
        }

        while(pA!=null&&pB!=null){
            if(pA==pB){
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }
}
