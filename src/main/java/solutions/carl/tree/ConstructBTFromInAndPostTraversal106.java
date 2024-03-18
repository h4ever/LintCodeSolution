package solutions.carl.tree;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInAndPostTraversal106 {

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return buildTree(inorder,postorder,0,inorder.length,0,postorder.length);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder,int inBegin, int inEnd, int postBegin, int postEnd) {
        if(postEnd==postBegin){
            return null;
        }
        int rootVal = postorder[postEnd-1];
        TreeNode root = new TreeNode(rootVal);
        if(postEnd==postBegin+1){
            return root;
        }
        int rootIndex = indexMap.get(rootVal);

        int leftLength = rootIndex-inBegin;

        root.left = buildTree(inorder,postorder,inBegin,rootIndex,postBegin,postBegin+leftLength);
        root.right = buildTree(inorder,postorder,rootIndex+1,inEnd,postBegin+leftLength,postEnd-1);
        return root;
    }
}
