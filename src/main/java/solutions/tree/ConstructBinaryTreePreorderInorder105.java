package solutions.tree;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePreorderInorder105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode build(int preStart, int inStart, int inEnd, int[] pre, int[] in) {
        if (preStart > pre.length - 1 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int inRoot = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                inRoot = i;
                break;
            }
        }
        root.left = build(preStart + 1, inStart, inRoot - 1, pre, in);
        root.right = build(preStart + inRoot - inStart + 1, inRoot + 1, inEnd, pre, in);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        int[] current = {0};
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)  inMap.put(inorder[i], i);
        return buildTree(preorder, current, 0, preorder.length - 1, inMap);
    }

    public TreeNode buildTree(int[] preorder, int[] current, int low, int high, Map<Integer, Integer> inMap) {
        if (current[0] == preorder.length) return null;
        if (low > high) return null;
        TreeNode root = new TreeNode(preorder[current[0]++]);
        int rootIdx = inMap.get(root.val);
        root.left = buildTree(preorder, current, low, rootIdx - 1, inMap);
        root.right = buildTree(preorder, current, rootIdx + 1, high, inMap);

        return root;
    }
}
