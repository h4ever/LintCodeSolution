package main.java.solutions.tree;

import main.java.structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree501 {
	/*
	Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than or equal to the node's key.
    The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
    Both the left and right subtrees must also be binary search trees.

	 */
	int maxCount = -1;
	List<Integer> modes = new ArrayList<>();
	
	public int[] findMode(TreeNode root){
		List<Integer> nodes = new ArrayList<>();
		inorderTraverse(root,nodes);
		findMode(nodes);
		int[] ans = new int[modes.size()];
		for(int i=0;i<modes.size();i++){
			ans[i]=modes.get(i);
		}
		return ans;
	}
	
	public void inorderTraverse(TreeNode root,List<Integer> nodes){
		if(root==null) return;
		inorderTraverse(root.left,nodes);
		nodes.add(root.val);
		inorderTraverse(root.right,nodes);
	}
	
	public void findMode(List<Integer> nodes){
		if(nodes.isEmpty()) return;
		int currCount = 1;
		int prev = nodes.get(0);
		for(int i=1;i<nodes.size();i++){
			int curr=nodes.get(i);
			if(curr==prev){
				currCount++;
			}else{
				updateModes(currCount,prev);
				currCount=1;
				prev=curr;
			}
		}
		updateModes(currCount,prev);

	}
	public void updateModes(int currCount,int prev){
		if(maxCount<currCount){
			maxCount = currCount;
			modes.clear();
			modes.add(prev);
		}else if(maxCount==currCount){
			modes.add(prev);
		}
	}
}
