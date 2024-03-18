package solutions.carl.tree;

import structure.TreeNode;

public class SearchInBST700 {

    /*
    给定二叉搜索树（BST）的根节点 root 和一个整数值 val。

你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val==val){
            return root;
        }
        return root.val<val?searchBST(root.right,val):searchBST(root.left,val);
    }
}
