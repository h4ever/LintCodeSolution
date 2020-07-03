package test.java.solutions.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import main.java.solutions.tree.ConstructBinaryTreePreorderInorder105;
import main.java.solutions.tree.PathSum437;
import main.java.structure.TreeNode;

public class PathSum437Test {

	@Test
	public void test() {
		int[] preOrder = {10,5,3,3,-2,2,1,-3,11};
		int[] inOrder = {3,3,-2,5,2,1,10,-3,11};
		ConstructBinaryTreePreorderInorder105 constructTree = new ConstructBinaryTreePreorderInorder105();
		
		TreeNode root = constructTree.buildTree(preOrder, inOrder);
		
		PathSum437 testInstance=new PathSum437();
		int paths = testInstance.pathSum(root, 8);
		System.out.println(paths);
	}

}