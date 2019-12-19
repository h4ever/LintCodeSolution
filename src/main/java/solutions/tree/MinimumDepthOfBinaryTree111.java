package main.java.solutions.tree;

import java.util.ArrayDeque;
import java.util.Deque;

import main.java.structure.TreeNode;

public class MinimumDepthOfBinaryTree111 {
	public int minDepth(TreeNode root) {
		if(root==null) return 0;
		int left = minDepth(root.left);
		int right=minDepth(root.right);
		return (left==0||right==0)?(left+right+1):Math.min(left, right)+1;
	}
	
	public int minDepthBFS(TreeNode root) {
		if(root==null) return 0;
		Deque<TreeNode> q = new ArrayDeque<>();
		int level=1;
		q.offer(root);
		while(!q.isEmpty()){
			int size=q.size();
			for(int i=0;i<size;i++){
				TreeNode node = q.poll();
				if(node.left==null&&node.right==null) return level;
				if(node.left!=null) q.offer(node.left);
				if(node.right!=null) q.offer(node.right);
			}
			level++;
		}
		return 0;
	}
}
