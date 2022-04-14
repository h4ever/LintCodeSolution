package solutions.tree;

import structure.TreeNode;

public class InvertBinaryTree226 {
    /*
    Invert a binary tree.
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;
        final TreeNode l = root.left , r = root.right;
        root.left = invertTree(r);
        root.right = invertTree(l);
        return root;
    }
}
