package main.java.solutions.tree;

import main.java.structure.Node;

import java.util.List;

public class MaximumDepthOfNaryTree559 {
    /*
    Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
     */
    public int maxDepth(Node root) {
        if(root==null) return 0;
        if(root.children==null) return 1;
        int maxDepth = 1;
        for(Node child:root.children){
            if(child!=null){
                maxDepth = Math.max(maxDepth,maxDepth(child)+1);
            }
        }
        return maxDepth;
    }
}
