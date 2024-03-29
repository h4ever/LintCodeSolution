package solutions.tree;

import structure.TreeNode;

public class MaximumDepthOfBinarTree104 {
    /*
    Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.
     */
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
}
