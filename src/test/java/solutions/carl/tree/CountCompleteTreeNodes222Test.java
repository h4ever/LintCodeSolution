package solutions.carl.tree;

import org.junit.Test;
import solutions.tree.ConstructBinaryTreePreorderInorder105;
import structure.TreeNode;

import static org.junit.Assert.*;

public class CountCompleteTreeNodes222Test {

    @Test
    public void countNodesDfs() {
        int[] preOrder = {1,2,4,5,3,6};
        int[] inOrder = {4,2,5,1,6,3};
        ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();

        TreeNode root = testInstance.buildTree(preOrder, inOrder);

        CountCompleteTreeNodes222 countCompleteTreeNodes222 = new CountCompleteTreeNodes222();
        int i = countCompleteTreeNodes222.countNodesDfs(root);
        System.out.println(i);
    }
}