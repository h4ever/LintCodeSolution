package solutions.carl.tree;

import org.junit.Test;
import structure.TreeNode;

import java.util.Stack;

import static org.junit.Assert.*;

public class LowestCommonAncestorOfBT236Test {

    @Test
    public void dfsTraversalP() {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t8 = new TreeNode(8);
        TreeNode t12 = new TreeNode(12);
        TreeNode t20 = new TreeNode(20);
        TreeNode t10 = new TreeNode(10);
        TreeNode t19 = new TreeNode(19);
        t1.left=t2;
        t1.right=t4;
        t2.left=t7;
        t2.right=t6;
        t4.left=t3;
        t4.right=t5;
        t3.left=t8;
        t3.right=t12;
        t5.right=t20;
        t12.left=t10;
        t12.right=t19;
        //downwardPath(t1,t10);
        LowestCommonAncestorOfBT236 lowestCommonAncestorOfBT236 = new LowestCommonAncestorOfBT236();
          Stack<TreeNode> path = new Stack<>();
        lowestCommonAncestorOfBT236.dfsTraversal(t1,t10,path);
        while(!path.isEmpty()){
            System.out.println(path.pop().val);
        }
    }
}