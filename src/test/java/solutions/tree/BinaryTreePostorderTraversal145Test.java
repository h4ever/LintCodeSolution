package test.java.solutions.tree;

import main.java.solutions.tree.BinaryTreePostorderTraversal145;
import main.java.solutions.tree.ConstructBinaryTreePreorderInorder105;
import main.java.structure.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreePostorderTraversal145Test {
    BinaryTreePostorderTraversal145 testInstance = new BinaryTreePostorderTraversal145();
    private static TreeNode root;
    static {
        int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
        int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
        ConstructBinaryTreePreorderInorder105 build = new ConstructBinaryTreePreorderInorder105();

        root = build.buildTree(preOrder, inOrder);
    }

    @Test
    public void postorderTraversal() {
        List<Integer> l =testInstance.postorderTraversal(root);
        System.out.println(l);
    }

    @Test
    public void postorderTraversal2() {
        List<Integer> l =testInstance.postorderTraversal2(root);
        System.out.println(l);
    }
}