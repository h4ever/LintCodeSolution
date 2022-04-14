package solutions.tree;

import solutions.tree.LeafSimilarTrees872;
import structure.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeafSimilarTrees872Test {
    /*
                       3
                3           3
             4     3     2     4
           4   4       2   2     5
                     2   1   2    5
        */
    @Test
    public void dfs() {
        TreeNode root = solutions.tree.LongestUnivaluePath687Test.generateTestData();
        LeafSimilarTrees872 testInstance = new LeafSimilarTrees872();
        String leaves = testInstance.dfs(root);
        System.out.println(leaves);
    }

    @Test
    public void dfs2() {
        TreeNode root = solutions.tree.LongestUnivaluePath687Test.generateTestData();
        LeafSimilarTrees872 testInstance = new LeafSimilarTrees872();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            int x = testInstance.dfs2(stack);
            System.out.println(x);
        }
    }
}