package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class SubtreeOfAnotherTree572 {
    /*
    Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null) return false;
        if(isSameTree(s,t)) return true;
        return isSubtree(s.left,t)||isSubtree(s.right,t);
    }

    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null||q==null) return false;
        if(p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
        return false;
    }
}
