package solutions.tree;

import solutions.tree.ConstructBinaryTreePreorderInorder105;
import solutions.tree.TrimABinarySearchTree669;
import structure.TreeNode;
import org.junit.Test;

public class TrimABinarySearchTree669Test {

    @Test
    public void trimBST() {
        int[] preOrder = {6,4,2,1,3,5,9,8,7,10};
        int[] inOrder = {1,2,3,4,5,6,7,8,9,10};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();

        TreeNode root = testInstance.buildTree(preOrder, inOrder);
        TrimABinarySearchTree669 testInstance2 = new TrimABinarySearchTree669();
        testInstance2.trimBST(root,4,8);
    }
}