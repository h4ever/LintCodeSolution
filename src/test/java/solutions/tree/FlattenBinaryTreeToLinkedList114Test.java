package solutions.tree;

import solutions.tree.BinaryTreeLevelOrderTraversal102;
import solutions.tree.ConstructBinaryTreePreorderInorder105;
import solutions.tree.FlattenBinaryTreeToLinkedList114;
import structure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class FlattenBinaryTreeToLinkedList114Test {

    @Test
    public void flatten1() {
        int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
        int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();

        TreeNode root = testInstance.buildTree(preOrder, inOrder);
        FlattenBinaryTreeToLinkedList114 testi = new FlattenBinaryTreeToLinkedList114();
        testi.flatten1(root);
        BinaryTreeLevelOrderTraversal102 testInstance2 = new BinaryTreeLevelOrderTraversal102();
        System.out.println(testInstance2.levelOrder(root));
    }

    @Test
    public void flatten2() {
        int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
        int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();

        TreeNode root = testInstance.buildTree(preOrder, inOrder);
        FlattenBinaryTreeToLinkedList114 testi = new FlattenBinaryTreeToLinkedList114();
        testi.flatten2(root);
        BinaryTreeLevelOrderTraversal102 testInstance2 = new BinaryTreeLevelOrderTraversal102();
        System.out.println(testInstance2.levelOrder(root));
    }
}