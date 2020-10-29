package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class FlattenBinaryTreeToLinkedList114 {
    /*
    Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6

The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
     */
    private TreeNode prev = null;
    public void flatten1(TreeNode root) {
        if(root==null) return;
        flatten1(root.right);
        flatten1(root.left);
        root.right=prev;
        root.left=null;
        prev=root;
    }

    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode last = cur.left;
                while (last.right != null) last = last.right;
                last.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
