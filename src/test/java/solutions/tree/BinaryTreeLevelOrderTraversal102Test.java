package test.java.solutions.tree;

import main.java.solutions.tree.BinaryTreeLevelOrderTraversal102;
import main.java.structure.TreeNode;
import org.junit.Test;

public class BinaryTreeLevelOrderTraversal102Test {

	@Test
	public void test() {
		TreeNode root=new TreeNode(1);
		TreeNode l1=new TreeNode(2);
		TreeNode r1=new TreeNode(3);
		root.left=l1;
		root.right=r1;
		TreeNode ll2=new TreeNode(4);
		TreeNode lr2=new TreeNode(5);
		TreeNode rr2=new TreeNode(6);
		l1.left=ll2;
		l1.right=lr2;
		r1.left=null;
		r1.right=rr2;
		BinaryTreeLevelOrderTraversal102 testInstance = new BinaryTreeLevelOrderTraversal102();
		System.out.println(testInstance.levelOrder2(root));
	}

}
