package main.java.solutions.tree;

import main.java.structure.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeafSimilarTrees872 {
    /*
    Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
    Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
Constraints:

    Both of the given trees will have between 1 and 200 nodes.
    Both of the given trees will have values between 0 and 200

     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return dfs(root1).equals(dfs(root2));
    }

    public String dfs(TreeNode root){
        if(root==null) return "";
        if(root.left==null&&root.right==null) return root.val+"-";
        String l = dfs(root.left);
        String r = dfs(root.right);
        return l+r;
    }

    public boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> s1=new ArrayDeque<>();
        Deque<TreeNode> s2=new ArrayDeque<>();
        s1.push(root1);
        s2.push(root2);
        while((!s1.isEmpty())&&(!s2.isEmpty())){
            if(dfs2(s1)!=dfs2(s2)) return false;
        }
        return s1.isEmpty()&&s2.isEmpty();

    }
    public int dfs2(Deque<TreeNode> s){
        while(true){
            TreeNode node=s.pop();
            if(node.right!=null) s.push(node.right);
            if(node.left!=null) s.push(node.left);
            if(node.left==null&&node.right==null) return node.val;
        }
    }

}
