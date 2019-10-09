package main.java.solutions;

import main.java.structure.ListNode;

public class DeleteNodeInALinkedList {
	public void deleteNode(ListNode node){
		ListNode nextNode = node.next;
		node.val=nextNode.val;
		node.next=nextNode.next;
	}
}
