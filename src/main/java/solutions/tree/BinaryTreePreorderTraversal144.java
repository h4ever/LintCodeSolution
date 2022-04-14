package solutions.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal144 {
    /*
    Given the root of a binary tree, return the preorder traversal of its nodes' values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(root!=null){
            ans.add(root.val);
            if(root.right!=null) s.push(root.right);
            root=root.left;
            if(root==null&&!s.isEmpty()) root=s.pop();
        }
        return ans;
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversal2(root,ans);
        return ans;
    }

    public void preorderTraversal2(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preorderTraversal2(root.left,list);
        preorderTraversal2(root.right,list);
    }

    public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            ans.add(cur.val);
            if(cur.right!=null) s.push(cur.right);
            if(cur.left!=null) s.push(cur.left);
        }
        return ans;
    }

    public List<Integer> preorderTraversal4(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        while(root!=null||!s.isEmpty()){
            while(root!=null){
                ans.add(root.val);
                s.push(root);
                root = root.left;
            }
            root=s.pop();
            root = root.right;
        }
        return ans;
    }
}
