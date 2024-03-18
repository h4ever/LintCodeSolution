package solutions.tree;

import structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue513 {
    /*
    Given a binary tree, find the leftmost value in the last row of the tree.
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode leftMost=root;
        while(!q.isEmpty()){
            int nodeCountInOneRow = q.size();
            while(nodeCountInOneRow-->0){
                leftMost = q.poll();
                if(leftMost.right!=null){
                    q.offer(leftMost.right);//右侧节点先入队
                }
                if(leftMost.left!=null){
                    q.offer(leftMost.left);
                }
            }
        }
        return leftMost.val;

    }
}
