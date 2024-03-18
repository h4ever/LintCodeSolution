package solutions.carl.tree;

import org.junit.Test;
import solutions.tree.ConstructBinaryTreePreorderInorder105;
import structure.TreeNode;

import static org.junit.Assert.*;

public class BinaryTreePaths257Test {

    @Test
    public void binaryTreePaths() {
        int[] preOrder = {1,2,5,3};
        int[] inOrder = {5,2,1,3};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();

        TreeNode root = testInstance.buildTree(preOrder, inOrder);

        BinaryTreePaths257 binaryTreePaths257 = new BinaryTreePaths257();
        binaryTreePaths257.binaryTreePaths(root);


    }
}