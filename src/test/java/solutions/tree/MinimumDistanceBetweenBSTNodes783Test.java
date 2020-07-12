package test.java.solutions.tree;

import main.java.solutions.tree.MinimumDistanceBetweenBSTNodes783;
import main.java.structure.TreeNode;
import org.junit.Test;

public class MinimumDistanceBetweenBSTNodes783Test {

    @Test
    public void minDiffInBST() {
        MinimumDistanceBetweenBSTNodes783 testIntance = new MinimumDistanceBetweenBSTNodes783();
        TreeNode root = generateTestData();
        testIntance.minDiffInBST(root);
    }

    public TreeNode generateTestData(){
        TreeNode root = new TreeNode(27);
        TreeNode r = new TreeNode(34);
        TreeNode rr = new TreeNode(58);
        TreeNode rrl = new TreeNode(50);
        TreeNode rrll = new TreeNode(44);
        root.right=r;r.right=rr;rr.left=rrl;rrl.left=rrll;
        return root;
    }
}