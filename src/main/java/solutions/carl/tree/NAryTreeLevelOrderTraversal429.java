package solutions.carl.tree;

import structure.Node;
import structure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NAryTreeLevelOrderTraversal429 {
    /*
    给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     */

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while(!q.isEmpty()){
            List<Integer> levelList = new ArrayList<>();

            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                levelList.add(node.val);
                if(node.children!=null) {
                    for (Node child : node.children) {
                        q.offer(child);
                    }
                }
            }
            res.add(levelList);
        }
        return res;
    }
}
