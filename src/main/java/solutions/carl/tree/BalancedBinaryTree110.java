package solutions.carl.tree;

import structure.TreeNode;

public class BalancedBinaryTree110 {
    /*
    给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     */



    public boolean isBalanced(TreeNode left,TreeNode right){
        int leftDepth = maxDepth(left);
        int rightDepth = maxDepth(right);
        if(Math.abs(leftDepth-rightDepth)>1){
            return false;
        }

        return isBalanced(left)&&isBalanced(right);

    }

    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        //return isBalanced(root.left,root.right);
        return depthFromBottomToTop(root)>0;
    }

    public int depthFromBottomToTop(TreeNode root) {
        if(root==null) return 0;
        int depthLeft = depthFromBottomToTop(root.left);
        int depthRight = depthFromBottomToTop(root.right);

        if(depthLeft==-1||depthRight==-1||Math.abs(depthLeft-depthRight)>1){
            return -1;
        }

        return 1+Math.max(depthLeft,depthRight);
    }

    public int maxDepth(TreeNode root){
        if(root==null) return 0;
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));

    }

}
