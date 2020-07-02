package test.java.solutions.tree;

import main.java.solutions.tree.BinaryTreeLevelOrderTraversal102;
import main.java.solutions.tree.ConstructBinaryTreePreorderInorder105;
import main.java.solutions.tree.ConvertBSTToGreaterTree538;
import main.java.structure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertBSTToGreaterTree538Test {
    /*
                1
           2                 4
        7     6           3         5
                       8     12       20
                           10  19
     */
    @Test
    public void convertBST2() {
        int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
        int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();

        TreeNode root = testInstance.buildTree(preOrder, inOrder);
        ConvertBSTToGreaterTree538.convertBST2(root);
        BinaryTreeLevelOrderTraversal102 testInstance2 = new BinaryTreeLevelOrderTraversal102();
        System.out.println(testInstance2.levelOrder(root));
    }

    @Test
    public void convertBST3() {
        int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
        int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();

        TreeNode root = testInstance.buildTree(preOrder, inOrder);
        ConvertBSTToGreaterTree538.convertBST3(root);
        BinaryTreeLevelOrderTraversal102 testInstance2 = new BinaryTreeLevelOrderTraversal102();
        System.out.println(testInstance2.levelOrder(root));
    }
}