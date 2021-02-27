package main.java.solutions.tree;

import main.java.structure.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBST449 {
    /*
    Serialization is converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You need to ensure that a binary search tree can be serialized to a string, and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.
Constraints:

    The number of nodes in the tree is in the range [0, 104].
    0 <= Node.val <= 104
    The input tree is guaranteed to be a binary search tree.
     */
    public static final String NULL_NODE = "#";
    public static final String SEP = ",";
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }

    private static void preorder(TreeNode root,StringBuilder sb){
        if(root==null) {
            sb.append(NULL_NODE).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        preorder(root.left,sb);
        preorder(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(SEP)));
        return deserialize(q);
    }

    private static TreeNode deserialize(Queue<String> q){
        String val = q.poll();
        if(val.equals(NULL_NODE)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left=deserialize(q);
        root.right=deserialize(q);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {4,2,1,3,12,6,5,8,7,10,19,20};
        int[] inOrder = {1,2,3,4,5,6,7,8,10,12,19,20};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();
        TreeNode root = testInstance.buildTree(preOrder,inOrder);
        String encode = serialize(root);
        System.out.println(encode);
        TreeNode x = deserialize(encode);
        BinaryTreePaths257 testIntance2 = new BinaryTreePaths257();
        List<String> res = testIntance2.binaryTreePaths2(x);
        System.out.println(res);

    }

}
