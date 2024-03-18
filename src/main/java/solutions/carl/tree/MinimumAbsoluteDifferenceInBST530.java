package solutions.carl.tree;

import structure.TreeNode;

import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST530 {
    public int getMinimumDifference(TreeNode root) {
        int res  = Integer.MAX_VALUE;
        Integer pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(pre!=null){
                res = Math.min(res,root.val-pre);
            }
            pre = root.val;
            root = root.right;
        }

        return res;
    }
}
