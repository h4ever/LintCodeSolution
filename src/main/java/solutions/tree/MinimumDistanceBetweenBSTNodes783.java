package solutions.tree;

import structure.TreeNode;

public class MinimumDistanceBetweenBSTNodes783 {
    /*
    Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
     */

    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public int minDiffInBST(TreeNode root) {
        if(root==null) return min;
        minDiffInBST(root.left);
        if(prev!=null) min = Math.min(min,root.val-prev);
        prev = root.val;
        minDiffInBST(root.right);
        return min;
    }

}

