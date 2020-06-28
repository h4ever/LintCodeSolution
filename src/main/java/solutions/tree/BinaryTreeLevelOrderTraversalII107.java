package main.java.solutions.tree;

import main.java.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII107 {
    /*
    Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> r = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode c = q.poll();
                r.add(c.val);
                if(c.left!=null) q.offer(c.left);
                if(c.right!=null) q.offer(c.right);
            }
            ans.add(0,r);
        }
        return ans;
    }
}
