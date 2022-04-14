package solutions.tree;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		 Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
	        
	        if(root == null) return wrapList;
	        
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int levelNum = queue.size();
	            List<Integer> subList = new LinkedList<Integer>();
	            for(int i=0; i<levelNum; i++) {
	                if(queue.peek().left != null) queue.offer(queue.peek().left);
	                if(queue.peek().right != null) queue.offer(queue.peek().right);
	                subList.add(queue.poll().val);
	            }
	            wrapList.add(subList);
	        }
	        return wrapList;
    }
	
	 public String levelOrder2(TreeNode root) {
	        Queue<TreeNode> queue = new LinkedList<TreeNode>();
	        StringBuilder res = new StringBuilder();
	        if(root == null) return null;
	        
	        queue.offer(root);
	        while(!queue.isEmpty()){
	            int levelNum = queue.size();

	            for(int i=0; i<levelNum; i++) {
	                if(queue.peek().left != null) {
	                	queue.offer(queue.peek().left);
	                }
	                if(queue.peek().right != null) {
	                	queue.offer(queue.peek().right);
	                }
	                res.append(queue.poll().val).append(",");
	            }
	        }
	        return res.toString();
	    }
}
