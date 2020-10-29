package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class CountCompleteTreeNodes222 {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int ld = leftDepth(root);
        int rd = rightDepth(root);
        if(ld==rd) return (1<<ld)-1;
        int lrd = rightDepth(root.left);
        if(lrd==ld-1){
            return (1<<lrd)+countNodes(root.right);
        }else{
            return (1<<lrd)+countNodes(root.left);
        }
    }

    public int leftDepth(TreeNode root){
        return root==null?0:1+leftDepth(root.left);
    }

    public int rightDepth(TreeNode root){
        return root==null?0:1+rightDepth(root.right);
    }
}
