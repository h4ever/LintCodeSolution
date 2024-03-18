package solutions.carl.tree;

import structure.TreeNode;

import java.util.Stack;

public class ValidateBST98 {
    /*
        给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

        有效 二叉搜索树定义如下：

        节点的左
        子树
        只包含 小于 当前节点的数。
        节点的右子树只包含 大于 当前节点的数。
        所有左子树和右子树自身必须也是二叉搜索树。
     */

    Integer preVal = null;
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node!=null){
                if(node.right!=null){
                    stack.push(node.right);
                }
                stack.push(node);
                stack.push(null);
                if(node.left!=null){
                    stack.push(node.left);
                }
            }else{
                if(preVal!=null&&stack.peek().val<=preVal){
                    return false;
                }
                preVal = stack.pop().val;
            }
        }
        return true;

    }

    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(preVal!=null&&preVal>=root.val){
                return false;
            }
            preVal = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST3(TreeNode root) {
        if(root==null) return true;
        boolean left = isValidBST3(root.left);
        if(preVal!=null&&preVal>=root.val){
            return false;
        }
        preVal = root.val;
        boolean right = isValidBST3(root.right);
        return left&&right;
    }

    public boolean isValidBST4(TreeNode root) {
        return isValidBST4(root,null,null);
    }

    public boolean isValidBST4(TreeNode root,TreeNode min, TreeNode max) {
        if(root==null){
            return true;
        }
        if(min!=null&&root.val<=min.val||max!=null&&root.val>=max.val){
            return false;
        }
        return isValidBST4(root.left,min,root)&&isValidBST4(root.right,root,max);
    }


}
