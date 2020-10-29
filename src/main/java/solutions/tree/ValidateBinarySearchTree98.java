package main.java.solutions.tree;

import main.java.structure.TreeNode;

import java.util.Stack;

public class ValidateBinarySearchTree98 {
    /*
    Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,null,null);
    }

    public boolean isValidBST(TreeNode root,TreeNode min,TreeNode max){
        if(root==null) return true;
        if(min!=null&&root.val<=min.val||max!=null&&root.val>=max.val) return false;
        return isValidBST(root.left,min,root)&&isValidBST(root.right,root,max);
    }

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        while(root!=null||!s.isEmpty()){
            while(root!=null){
                s.push(root);root=root.left;
            }
            root = s.pop();
            if(pre!=null&&pre.val>=root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
