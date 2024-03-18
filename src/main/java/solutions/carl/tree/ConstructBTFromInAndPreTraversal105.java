package solutions.carl.tree;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInAndPreTraversal105 {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return buildTree(inorder,preorder,0,inorder.length,0,preorder.length);
    }

    public TreeNode buildTree(int[] inorder, int[] preorder,int inBegin, int inEnd, int preBegin, int preEnd) {
        if(preBegin>=preEnd||inBegin>=inEnd){
            return null;
        }
        int rootVal = preorder[preBegin];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = indexMap.get(rootVal);

        int leftLength = rootIndex-inBegin;

        root.left = buildTree(inorder,preorder,inBegin,rootIndex,preBegin+1,preBegin+1+leftLength);
        root.right = buildTree(inorder,preorder,rootIndex+1,inEnd,preBegin+1+leftLength,preEnd);
        return root;
    }
}
