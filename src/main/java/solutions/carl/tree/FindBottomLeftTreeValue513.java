package solutions.carl.tree;

import structure.TreeNode;

public class FindBottomLeftTreeValue513 {
    int maxDepth = 0;
    int result = 0;
    public int findBottomLeftValue(TreeNode root) {

        findBottomLeftValue(root,0);
        return result;

    }

    public void findBottomLeftValue(TreeNode root,int depth) {
        if(root==null){
            return;
        }

        if(root.left==null&&root.right==null){
            if(depth>maxDepth){
                maxDepth = depth;
                result = root.val;
            }
        }
        findBottomLeftValue(root.left,depth+1);
        findBottomLeftValue(root.right,depth+1);
    }


}
