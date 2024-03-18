package solutions.carl.tree;

import structure.TreeNode;

public class InvertBinaryTree226 {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        TreeNode l = root.left;
        TreeNode r = root.right;
        if(l==null&&r==null){
            return root;
        }
        root.left = invertTree(r);
        root.right = invertTree(l);
        return root;
    }
}
