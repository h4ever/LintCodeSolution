package main.java.solutions.tree;

import main.java.structure.TreeNode;


public class BalancedBinaryTree110 {
    /*
    Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

    a binary tree in which the left and right subtrees of every node differ in height by no more than 1.

     */
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int leftDepth =  MaximumDepthOfBinarTree104.maxDepth(root.left);
        int rightDepth =  MaximumDepthOfBinarTree104.maxDepth(root.right);
        return Math.abs(leftDepth-rightDepth)<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
}
