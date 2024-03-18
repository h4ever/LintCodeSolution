package solutions.carl.tree;

import structure.TreeNode;

public class InsertIntoBST701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {

        if(root==null) {
            return new TreeNode(val);
        }

        if(root.val>val){
            root.left = insertIntoBST(root.left,val);
        }else{
            root.right = insertIntoBST(root.right,val);
        }

        return root;

    }

    public TreeNode insertIntoBSTIteration(TreeNode root, int val) {

        if(root==null) {
            return new TreeNode(val);
        }

        TreeNode p = root,parent = root;

        while(p!=null){
            parent = p;
            p = p.val>val?p.left:p.right;
        }
        if(parent.val>val){
            parent.left = new TreeNode(val);
        }else{
            parent.right = new TreeNode(val);
        }
        return root;

    }
}
