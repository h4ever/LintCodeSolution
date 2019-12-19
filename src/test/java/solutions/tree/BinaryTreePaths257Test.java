package test.java.solutions.tree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import main.java.solutions.tree.BinaryTreePaths257;
import main.java.structure.TreeNode;

public class BinaryTreePaths257Test {

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
		
		BinaryTreePaths257 testIntance = new BinaryTreePaths257();
		List<String> res = testIntance.binaryTreePaths2(root);
		System.out.println(res);
	}

}
