package main.java.solutions.tree;

import main.java.structure.TreeNode;

import java.util.Stack;

public class IncreasingOrderSearchTree897 {
    /*
    Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
     */
    TreeNode prev=null,head=null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return null;
        increasingBST(root.left);
        if(prev!=null){
            root.left=null;
            prev.right=root;
        }
        if(head==null){
            head=root;
        }
        prev=root;
        increasingBST(root.right);
        return head;
    }

    public TreeNode increasingBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode dummy = new TreeNode(0), p = dummy;
        while (root != null || !stack.empty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode cur = stack.pop();
                root = cur.right;
                cur.left = null;
                p.right = cur;
                p = p.right;
            }
        }
        return dummy.right;
    }

}
