package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class RangeSumOfBST938 {
    /*
    Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null) return 0;
        if(root.val<L){
            return rangeSumBST(root.right,L,R);
        }
        if(root.val>R){
            return rangeSumBST(root.left,L,R);
        }
        int l = rangeSumBST(root.left,L,R);
        int r = rangeSumBST(root.right,L,R);
        return l+r+root.val;
    }
}
