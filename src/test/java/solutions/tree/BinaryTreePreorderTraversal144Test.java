package test.java.solutions.tree;

import main.java.solutions.tree.BinaryTreePreorderTraversal144;
import main.java.solutions.tree.ConstructBinaryTreePreorderInorder105;
import main.java.structure.TreeNode;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreePreorderTraversal144Test {

    BinaryTreePreorderTraversal144 testInstance = new BinaryTreePreorderTraversal144();
    private static TreeNode root;
    static {
        int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
        int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
        ConstructBinaryTreePreorderInorder105 build = new ConstructBinaryTreePreorderInorder105();

        root = build.buildTree(preOrder, inOrder);
    }
    @Test
    public void preorderTraversal() {
        List<Integer> l = testInstance.preorderTraversal(root);
        System.out.println(l);
    }

    @Test
    public void preorderTraversal2() {
        List<Integer> l = testInstance.preorderTraversal2(root);
        System.out.println(l);
    }

    @Test
    public void preorderTraversal3() {
        List<Integer> l = testInstance.preorderTraversal3(root);
        System.out.println(l);
    }

    @Test
    public void preorderTraversal4() {
        System.out.println(testInstance.preorderTraversal4(root));
    }
}