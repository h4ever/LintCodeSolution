package main.java.solutions.tree;

import main.java.structure.TreeNode;

import java.util.Stack;

public class ConvertBSTToGreaterTree538 {
    /*
    Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
    This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
     */
    int preSum = 0;
    public TreeNode convertBST(TreeNode root) {
        convertBST(root.right);
        root.val+=preSum;
        preSum = root.val;
        convertBST(root.left);
        return root;
    }

    public static TreeNode convertBST2(TreeNode root) {
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int sum = 0;
        while (node != null || stack.size() > 0) {
            if (node != null) {
                stack.push(node);
                node = node.right;
            } else {
                node = stack.pop();
                sum += node.val;
                node.val = sum;
                node = node.left;
            }
        }
        return root;
    }
    public static TreeNode convertBST3(TreeNode root) {
        dfs(root, 0);
        return root;
    }

    public static  int dfs(TreeNode root, int val) {
        if(root == null) return val;
        int right = dfs(root.right, val);
        root.val = root.val + right;
        return dfs(root.left, root.val);
    }

}
