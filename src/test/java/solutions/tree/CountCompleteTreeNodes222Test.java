package test.java.solutions.tree;

import main.java.solutions.tree.CountCompleteTreeNodes222;
import main.java.structure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountCompleteTreeNodes222Test {

    @Test
    public void countNodes() {
        TreeNode left = new TreeNode(2,new TreeNode(4),null);
        TreeNode right = new TreeNode(3);
        TreeNode root = new TreeNode(1,left,right);

        CountCompleteTreeNodes222 testi= new CountCompleteTreeNodes222();
        System.out.println(testi.countNodes(root));
    }
}