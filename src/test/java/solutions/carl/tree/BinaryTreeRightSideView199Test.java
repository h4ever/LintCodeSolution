package solutions.carl.tree;

import org.junit.Test;
import solutions.tree.ConstructBinaryTreePreorderInorder105;
import structure.TreeNode;

import static org.junit.Assert.*;

public class BinaryTreeRightSideView199Test {

    @Test
    public void rightSideViewDfs() {
        BinaryTreeRightSideView199 test = new BinaryTreeRightSideView199();
        int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
        int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();

        TreeNode root = testInstance.buildTree(preOrder, inOrder);

        test.rightSideViewDfs(root);
    }
}