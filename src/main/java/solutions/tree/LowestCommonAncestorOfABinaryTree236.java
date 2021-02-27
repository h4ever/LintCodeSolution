package main.java.solutions.tree;

import main.java.structure.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorOfABinaryTree236 {
    /*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
Constraints:

    The number of nodes in the tree is in the range [2, 105].
    -109 <= Node.val <= 109
    All Node.val are unique.
    p != q
    p and q will exist in the tree.

     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode l = lowestCommonAncestor(root.left,p,q);
        TreeNode r = lowestCommonAncestor(root.right,p,q);
        if(l==null) return r;
        if(r==null) return l;
        return root;
    }

    public static Stack<TreeNode> downwardPath(TreeNode root, TreeNode x){
        Stack<TreeNode> ans = new Stack<>();
        if(root==null) return ans;
        ans.push(root);
        if(root==x) return ans;
        Stack<TreeNode> l = downwardPath(root.left,x);
        Stack<TreeNode> r = downwardPath(root.right,x);
        if(l.isEmpty()&&r.isEmpty()){
            ans.pop();return ans;
        }
        ans.addAll(l.isEmpty()?r:l);
        return ans;
    }

    public static boolean downwardPath(TreeNode root,TreeNode x,Stack<TreeNode> s){
        if(root==null) return false;
        s.push(root);
        if(root==x) return true;
        boolean inl = downwardPath(root.left,x,s);
        boolean inr = downwardPath(root.right,x,s);
        if(!inl&&!inr) s.pop();
        return inl||inr;

    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        Stack<TreeNode> ps = new Stack<>();
        Stack<TreeNode> qs = new Stack<>();
        downwardPath(root,p,ps);
        downwardPath(root,q,qs);
        Set<TreeNode> pans = new HashSet<>();
        while(!ps.isEmpty()){
            pans.add(ps.pop());
        }
        while(!qs.isEmpty()){
            TreeNode ans = qs.pop();
            if(pans.contains(ans)){
                return ans;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t8 = new TreeNode(8);
        TreeNode t12 = new TreeNode(12);
        TreeNode t20 = new TreeNode(20);
        TreeNode t10 = new TreeNode(10);
        TreeNode t19 = new TreeNode(19);
        t1.left=t2;
        t1.right=t4;
        t2.left=t7;
        t2.right=t6;
        t4.left=t3;
        t4.right=t5;
        t3.left=t8;
        t3.right=t12;
        t5.right=t20;
        t12.left=t10;
        t12.right=t19;
        //downwardPath(t1,t10);
        Stack<TreeNode> ans = new Stack<>();
        downwardPath(t1,t10,ans);

    }
}
