package solutions.tree;

import structure.TreeNode;

public class SecondMinimumNodeInaBinaryTree671 {
    /*
    Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes. More formally, the property root.val = min(root.left.val, root.right.val) always holds.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.
     */
    public int findSecondMinimumValue(TreeNode root) {
        if(root.left==null) return -1;
        int l = root.val==root.left.val?findSecondMinimumValue(root.left):root.left.val;
        int r = root.val==root.right.val?findSecondMinimumValue(root.right):root.right.val;
        return (l==-1||r==-1)?Math.max(l,r):Math.min(l,r);
    }
}
