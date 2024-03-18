package solutions.carl.tree;

import structure.TreeNode;

public class CountCompleteTreeNodes222 {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }

        return 1+countNodes(root.left)+countNodes(root.right);
    }

    public int countNodesDfs(TreeNode root) {
        if(root==null){
            return 0;
        }

        int leftDepth = leftMaxDepth(root);
        int rightDepth = rightMaxDepth(root);
        if(leftDepth==rightDepth){
            return (1<<leftDepth)-1;
        }

        int rightDepthOfLeft = rightMaxDepth(root.left);

        if(rightDepthOfLeft==leftDepth-1){
            return (1<<rightDepthOfLeft)+countNodesDfs(root.right);
        }else{
            return (1<<rightDepthOfLeft)+countNodesDfs(root.left);
        }


    }


    public int leftMaxDepth(TreeNode root){
        if(root==null) return 0;
        int depth = 0;
        while(root!=null){
            depth++;
            root = root.left;
        }
        return depth;
    }

    public int rightMaxDepth(TreeNode root){
        if(root==null) return 0;
        int depth = 0;
        while(root!=null){

            depth++;
            root = root.right;
        }
        return depth;
    }
}
