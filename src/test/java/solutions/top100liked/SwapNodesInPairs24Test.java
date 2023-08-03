package solutions.top100liked;

import org.junit.Test;
import structure.ListNode;

import static org.junit.Assert.*;

public class SwapNodesInPairs24Test {

    @Test
    public void swapPairs() {
        ListNode head = ListNode.generateList("1->2->3->4->null");
        SwapNodesInPairs24 test = new SwapNodesInPairs24();
        ListNode x = test.swapPairs(head);
        System.out.println(x);
    }
}