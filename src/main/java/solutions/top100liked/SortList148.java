package solutions.top100liked;

import structure.ListNode;

import java.util.Arrays;

public class SortList148 {
    public ListNode sortList(ListNode head) {
        ListNode sentinal1 = new ListNode(Integer.MAX_VALUE);
        ListNode sentinal2 = new ListNode(Integer.MAX_VALUE);
        sentinal2.next = head;

        while(sentinal2.next!=sentinal1.next&&sentinal2.next!=null){
            ListNode iterator = sentinal2.next;
            ListNode prev = sentinal2;

            ListNode max = sentinal2.next;
            ListNode maxPrev = sentinal2;

            while(iterator!=null){
                if(iterator.val>max.val){
                    maxPrev = prev;
                    max = iterator;
                }
                prev = iterator;
                iterator = iterator.next;
            }
            maxPrev.next = max.next;
            max.next = sentinal1.next;
            sentinal1.next = max;

        }
        return sentinal1.next;
    }

    public static  ListNode sortListQuick(ListNode head) {
        quickSortList(head,null);
        return head;
    }

    public static void swapNodeVal(ListNode n1,ListNode n2){
        int tmp = n1.val;
        n1.val = n2.val;
        n2.val = tmp;
    }

    public static ListNode qsortList(ListNode begin,ListNode end){
        int val = begin.val;
        ListNode  p = begin;
        ListNode q = p.next;
        while(q!=end){
            if(q.val < val){
                p = p.next;
                swapNodeVal(p,q);
            }
            q = q.next;
        }
        if(p!=begin){
            swapNodeVal(p,begin);
        }
        return p;

    }

    public static void quickSortList(ListNode begin,ListNode end){
        if(begin!=end){
            ListNode m = qsortList(begin,null);
            quickSortList(begin,m);
            quickSortList(m.next,end);
        }

    }


    public static  ListNode sortListMerge(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid = getMidNode(head);
        ListNode r = mid.next;
        mid.next = null;
        return mergeTwoLists(sortListMerge(head),sortListMerge(r));
    }

    public static ListNode getMidNode(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }

}
