package solutions.tree;

import structure.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal589 {
    /*
    Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
Constraints:

    The height of the n-ary tree is less than or equal to 1000
    The total number of nodes is between [0, 10^4]

     */
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraverse(root,ans);
        return ans;
    }

    public void preorderTraverse(Node root,List<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
        for(Node child:root.children){
            if(child!=null) preorderTraverse(child,ans);
        }
    }

    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }

        return list;
    }
}
