package solutions.tree;

import solutions.tree.ConstructBinaryTreePreorderInorder105;
import solutions.tree.MinimumDepthOfBinaryTree111;
import structure.TreeNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumDepthOfBinaryTree111Test {

	@Test
	public void test() {
		int[] preOrder = {10,5,3,3,-2,2,1,-3,11};
		int[] inOrder = {3,3,-2,5,2,1,10,-3,11};
		ConstructBinaryTreePreorderInorder105 constructTree = new ConstructBinaryTreePreorderInorder105();
		
		TreeNode root = constructTree.buildTree(preOrder, inOrder);
		
		MinimumDepthOfBinaryTree111 testInstance = new MinimumDepthOfBinaryTree111();
		assertEquals(testInstance.minDepth(root), 3);
		assertEquals(testInstance.minDepthBFS(root), 3);
	}

}
