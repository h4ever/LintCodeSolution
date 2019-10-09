package main.java.solutions;

import main.java.structure.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1,ListNode l2){
		ListNode sentinal = new ListNode(0);
		
		ListNode p1=l1;
		ListNode p2=l2;
		ListNode p = sentinal;
		
		int sum = 0;
		
		while(p1!=null || p2!=null){
			sum /= 10;
			if(p1!=null){
				sum += p1.val;
				p1 = p1.next;
			}
			if(p2!=null){
				sum += p2.val;
				p2 = p2.next;
			}
			p.next = new ListNode(sum%10);
			p = p.next;
		}
		
		if(sum>=10){
			p.next = new ListNode(1);
		}
		
		return sentinal.next;
	}
}
