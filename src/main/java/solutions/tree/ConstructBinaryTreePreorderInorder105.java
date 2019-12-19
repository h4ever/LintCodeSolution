package main.java.solutions.tree;

import main.java.structure.TreeNode;

public class ConstructBinaryTreePreorderInorder105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0,0,inorder.length-1,preorder,inorder);
    }
    
    public TreeNode build(int preStart,int inStart,int inEnd ,int[] pre ,int[] in){
        if(preStart>pre.length-1||inStart>inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = 0;
        for(int i=inStart;i<=inEnd;i++){
            if(in[i]==root.val){
                inRoot = i;
                break;
            }
        }
        root.left=build(preStart+1,inStart,inRoot-1,pre,in);
        root.right=build(preStart+inRoot-inStart+1,inRoot+1,inEnd,pre,in);
        return root;
    }
}
