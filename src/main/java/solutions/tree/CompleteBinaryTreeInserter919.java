package solutions.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CompleteBinaryTreeInserter919 {
    class CBTInserter {
        /*
        A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

    CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
    CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
    CBTInserter.get_root() will return the head node of the tree.

               0
            1         2
         3   4      5    6
        7 8 9 10  11
         */

        public List<TreeNode> nodes;

        public CBTInserter(TreeNode root) {
            nodes = new ArrayList<>();
            nodes.add(root);
            for(int i=0;i<nodes.size();i++){
                if(nodes.get(i).left!=null) nodes.add(nodes.get(i).left);
                if(nodes.get(i).right!=null) nodes.add(nodes.get(i).right);
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            int n = nodes.size();
            nodes.add(node);
            if(n%2==1){
                nodes.get((n-1)/2).left=node;
            }else{
                nodes.get((n-1)/2).right=node;
            }
            return nodes.get((n-1)/2).val;
        }

        public TreeNode get_root() {
            return nodes.get(0);
        }


    }
}
