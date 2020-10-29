package test.java.solutions.tree;

import main.java.solutions.tree.BinaryTreeLevelOrderTraversal102;
import main.java.solutions.tree.ConstructBinaryTreePreorderInorder105;
import main.java.structure.TreeNode;
import org.junit.Test;

public class ConstructBinaryTreePreorderInorder105Test {
    /*
                1
           2                 4
        7     6           3         5
                       8     12       20
                           10  19
     */
	@Test
	public void buildTree() {
		int[] preOrder = {1,2,7,6,4,3,8,12,10,19,5,20};
		int[] inOrder = {7,2,6,1,8,3,10,12,19,4,5,20};
		ConstructBinaryTreePreorderInorder105 testInstance = new ConstructBinaryTreePreorderInorder105();
		
		TreeNode root = testInstance.buildTree(preOrder, inOrder);
		TreeNode root2 = testInstance.buildTree2(preOrder,inOrder);
		BinaryTreeLevelOrderTraversal102 testInstance2 = new BinaryTreeLevelOrderTraversal102();
		System.out.println(testInstance2.levelOrder(root));
		System.out.println(testInstance2.levelOrder(root2));
	}

}
