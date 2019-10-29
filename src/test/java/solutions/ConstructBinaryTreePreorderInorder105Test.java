package test.java.solutions;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.BinaryTreeLevelOrderTraversal102;
import main.java.solutions.ConstructBinaryTreePreorderInorder105;
import main.java.structure.TreeNode;

public class ConstructBinaryTreePreorderInorder105Test {

	@Test
	public void buildTree() {
		int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
		int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
		ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();
		
		TreeNode root = testInstance.buildTree(preOrder, inOrder);
		BinaryTreeLevelOrderTraversal102 testInstance2 = new BinaryTreeLevelOrderTraversal102();
		System.out.println(testInstance2.levelOrder(root));
	}

}
