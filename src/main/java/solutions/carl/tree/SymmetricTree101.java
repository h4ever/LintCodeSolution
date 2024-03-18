package solutions.carl.tree;

import structure.TreeNode;

public class SymmetricTree101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSymmetric(root.left,root.right);
    }

    public boolean isSymmetric(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }

        if(left==null||right==null){
            return false;
        }

        if(left.val!=right.val){
            return false;
        }

        return isSymmetric(left.left,right.right)&&isSymmetric(left.right,right.left);

    }

    public boolean isSameTree(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }

        if(left==null||right==null){
            return false;
        }

        if(left.val!=right.val){
            return false;
        }

        return isSameTree(left.left,right.left)&&isSameTree(left.right,right.right);

    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return false;
        }

        if(isSameTree(root,subRoot)){
            return true;
        }



        return isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot);
    }

}
