package solutions.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal94 {
    /*
    Given the root of a binary tree, return the inorder traversal of its nodes' values.
     */


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        ans.addAll(inorderTraversal(root.left));
        ans.add(root.val);
        ans.addAll(inorderTraversal(root.right));
        return ans;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(root!=null||!s.isEmpty()){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root=s.pop();
            ans.add(root.val);
            root = root.right;
        }
        return ans;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(root!=null||!s.isEmpty()){
            if(root!=null){
                s.push(root);
                root = root.left;
            }else{
                root=s.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }
}
