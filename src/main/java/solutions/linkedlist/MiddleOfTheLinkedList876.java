package solutions.linkedlist;

import structure.ListNode;

import java.util.Arrays;
import java.util.Comparator;

public class MiddleOfTheLinkedList876 {
    public static ListNode middleNode(ListNode head) {
        ListNode walker = head;
        ListNode runner = head;
        while(runner!=null&&runner.next!=null){
            runner = runner.next.next;
            walker=walker.next;
        }
        return walker;
    }

    public static void main(String[] args) {
        //ListNode m = middleNode(ListNode.generateList("1->2->3->4->5->null"));
        //System.out.println(m);
        System.out.println(Integer.bitCount(5));
        Integer[] a = {1,2,3,4,5};
        Arrays.sort(a, Comparator.comparing( i->Integer.bitCount(i) ));

    }
}
