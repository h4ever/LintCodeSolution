package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class ConstructStringFromBinaryTree606 {
    /*
    You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.
     */
    public String tree2str(TreeNode t) {
        if(t==null) return "";
        StringBuilder ans =  new StringBuilder();
        preorder(t,ans);
        return ans.toString();
    }

    public void preorder(TreeNode t,StringBuilder s){
        if(t==null) return;
        s.append(t.val);
        if(t.left!=null||t.right!=null){
            s.append("(");
            preorder(t.left,s);
            s.append(")");
        }

        if(t.right!=null){
            s.append("(");
            preorder(t.right,s);
            s.append(")");
        }
    }
}
