package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class SymmetricTree101 {
    /*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     */
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetricHelper(root.left,root.right);
    }

    public boolean isSymmetricHelper(TreeNode l,TreeNode r){
        if(l==null&&r==null) return true;
        if(l==null||r==null) return false;
        if(l.val!=r.val) return false;
        return isSymmetricHelper(l.left,r.right)&&isSymmetricHelper(l.right,r.left);
    }
}
