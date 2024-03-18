package solutions.carl.tree;

import structure.TreeNode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorOfBT236 {
    /*
    给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     */

    private  Stack<TreeNode> pathP = new Stack<>();
    private  Stack<TreeNode> pathQ = new Stack<>();

    public  TreeNode lowestCommonAncestorBottomToUp(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null){
            return root;
        }

        TreeNode left = lowestCommonAncestorBottomToUp(root.left,p,q);
        TreeNode right = lowestCommonAncestorBottomToUp(root.right,p,q);
        if(left!=null&&right!=null){
            return root;
        }
        return left!=null?left:right;
    }

    public  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfsTraversal(root,p,pathP);
        dfsTraversal(root,q,pathQ);

        Set<TreeNode> setPathP = new HashSet<>();
        while(!pathP.isEmpty()){
            setPathP.add(pathP.pop());
        }
        while(!pathQ.isEmpty()){
            TreeNode ans = pathQ.pop();
            if(setPathP.contains(ans)){
                return ans;
            }
        }
        return null;
    }

    public  boolean dfsTraversal(TreeNode root, TreeNode x,Stack<TreeNode> path){
        if(root==null){
            return false;
        }
        path.push(root);
        if(root == x){
            return true;
        }
        if(dfsTraversal(root.left,x,path)){
            return true;
        }

        if(dfsTraversal(root.right,x,path)){
            return true;
        }
        path.pop();

        return false;
    }


}
