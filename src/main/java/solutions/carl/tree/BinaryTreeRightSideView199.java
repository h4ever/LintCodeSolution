package solutions.carl.tree;

import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeRightSideView199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){

            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(i==size-1){
                    res.add(node.val);
                }

                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return  res;
    }

    private List<Integer> ans;

    public List<Integer> rightSideViewDfs(TreeNode root) {
        ans = new ArrayList<>();
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (ans.size() <= depth){
            ans.add(node.val);
        } else{
            ans.set(depth, node.val);
        }

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
