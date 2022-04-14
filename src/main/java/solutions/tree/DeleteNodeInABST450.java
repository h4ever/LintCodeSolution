package solutions.tree;

import structure.TreeNode;

import java.util.List;

public class DeleteNodeInABST450 {
    /*
    Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

    Search for a node to remove.
    If the node is found, delete the node.

Follow up: Can you solve it with time complexity O(height of tree)?
Constraints:

    The number of nodes in the tree is in the range [0, 104].
    -105 <= Node.val <= 105
    Each node has a unique value.
    root is a valid binary search tree.
    -105 <= key <= 105

     */

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode newRoot = root.left ,par = null;
            while(newRoot.right!=null) {
                par = newRoot;
                newRoot = newRoot.right;
            }
            if(par==null){
                newRoot.right = root.right;
                return newRoot;
            }
            par.right = newRoot.left;
            newRoot.left = root.left;
            newRoot.right = root.right;
            return newRoot;
        }
        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val<key){
            root.right = deleteNode(root.right,key);
        }else if(root.val>key){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;
            TreeNode rightMost = root.left;
            while(rightMost.right!=null) rightMost = rightMost.right;
            rightMost.right=root.right;
            return root.left;
        }
        return root;
    }

    public static TreeNode insertNode(TreeNode root,TreeNode x){
        if(root==null) return x;
        if(root.val>x.val){
            root.left = insertNode(root.left,x);
        }else{
            root.right = insertNode(root.right,x);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {4,2,1,3,12,6,5,8,7,10,19,20};
        int[] inOrder = {1,2,3,4,5,6,7,8,10,12,19,20};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();
        TreeNode root = testInstance.buildTree(preOrder,inOrder);
        TreeNode newRoot = insertNode(root,new TreeNode(13));

        BinaryTreePaths257 testIntance2 = new BinaryTreePaths257();
        List<String> res = testIntance2.binaryTreePaths2(newRoot);
        System.out.println(res);

    }

}
