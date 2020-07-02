package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class DiameterOfBinaryTree543 {
    /*
    Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
    Note: The length of path between two nodes is represented by the number of edges between them.
     */
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(max,left+right);
        return Math.max(left,right)+1;
    }
}
