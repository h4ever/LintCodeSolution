package solutions.twopointers;

import structure.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle141 {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        Set<ListNode> seen = new HashSet<>();
        seen.add(head);
        while(head.next!=null){
            head = head.next;
            if(!seen.add(head)) return true;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if(head==null) return false;
        ListNode walker = head ,runner=  head;
        while(runner.next!=null&&runner.next.next!=null){
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }
}
