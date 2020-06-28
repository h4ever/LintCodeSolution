package main.java.solutions.linkedlist;

import main.java.structure.ListNode;

public class RemoveLinkedListElements203 {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode sentinal = new ListNode(0);
        sentinal.next = head;
        ListNode p =head,prev = sentinal;
        while(p!=null){
            if(p.val==val){
                ListNode tmp = p;
                prev.next = p.next;
                p = p.next;
                tmp.next = null;

            }else{
                prev = p;
                p = p.next;
            }
        }
        return sentinal.next;
    }

    public static void main(String[] args) {
        System.out.println(removeElements(ListNode.generateList("1->2->6->3->4->5->6->null"),6));
    }
}
