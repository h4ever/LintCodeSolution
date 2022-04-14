package solutions.tree;

import structure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal590 {
    /*
    Given an n-ary tree, return the postorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
     */
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraverse(root,ans);
        return ans;
    }

    public void postorderTraverse(Node root,List<Integer> ans){
        if(root==null) return;
        for(Node child:root.children){
            if(child!=null) postorderTraverse(child,ans);
        }
        ans.add(root.val);
    }

    public List<Integer> postorder2(Node root) {
        List<Integer> list = new LinkedList<>();
        if(root == null)  return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            List<Node> children = node.children;
            list.add(0,node.val);
            for(Node child:children){
                stack.push(child);
            }
        }
        return list;
    }

}
