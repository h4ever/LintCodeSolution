package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class BinaryTreeTilt563 {
    /*
    Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.
     */
    public int findTilt(TreeNode root) {
        if(root==null) return 0;
        int left = sumOfAllNodes(root.left);
        int right = sumOfAllNodes(root.right);
        int tilt = Math.abs(left-right);
        return tilt + findTilt(root.left) + findTilt(root.right);
    }

    public int sumOfAllNodes(TreeNode root){
        if(root==null) return 0;
        return root.val + sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
    }

    int tilts = 0;
    public int findTilt2(TreeNode root) {
        postOrder(root);
        return tilts;
    }

    public int postOrder(TreeNode root){
        if(root==null) return 0;
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        tilts += Math.abs(left-right);
        return left+right+root.val;
    }
}
