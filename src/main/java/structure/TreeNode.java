package main.java.structure;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int val){
		this.val=val;
	}
	
	public TreeNode constructTree(String s){
		String[] nodes  = s.split(",");
		TreeNode root=new TreeNode(Integer.parseInt(nodes[0]));
		int level=1;
		for(int i=1;i<nodes.length;i++){

		}
		return root;
	}
	
	
	 
}
