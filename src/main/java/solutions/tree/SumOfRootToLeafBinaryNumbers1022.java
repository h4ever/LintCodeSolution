package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class SumOfRootToLeafBinaryNumbers1022 {
    /*
    Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.
     */
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode root,int sumNow){
        if(root==null) return 0;
        sumNow = sumNow*2+root.val;
        if(root.left==null&&root.right==null) return sumNow;
        return dfs(root.left,sumNow)+dfs(root.right,sumNow);
    }
}
