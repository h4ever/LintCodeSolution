package solutions.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree637 {
    /*
    Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0;
            for(int i=0;i<size;i++){
                TreeNode c = q.poll();
                sum += c.val;
                if(c.left!=null) q.offer(c.left);
                if(c.right!=null) q.offer(c.right);
            }
            ans.add(sum/size);
        }
        return ans;
    }
}
