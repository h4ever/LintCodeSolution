package solutions.twopointers;

import structure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList234 {
    public static boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while(p!=null){
            list.add(p.val);
            p = p.next;
        }
        int l=0,r=list.size()-1;
        while(l<r){
            if(!list.get(l).equals(list.get(r))) return false;
            else{
                l++;
                r--;
            }

        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;
        System.out.println(fast);
        System.out.println(slow);

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode head = ListNode.generateList("1->1->2->1->1->null");
        System.out.println(isPalindrome2(head));
    }
}
