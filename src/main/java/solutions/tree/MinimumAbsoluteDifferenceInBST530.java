package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class MinimumAbsoluteDifferenceInBST530 {
    /*
    Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

    There are at least two nodes in this BST.
    This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/

     */
    Integer prev=null;
    int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null) return 0;
        getMinimumDifference(root.left);
        if(prev!=null){
            if(root.val==prev) return 0;
            min = Math.min(min,root.val-prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }

}
