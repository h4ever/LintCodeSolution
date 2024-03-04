package solutions.tree;

import structure.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null) return  result;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        TreeNode cur, pre=null;
        while (!stack.isEmpty()){
            cur=stack.peek();
            if(cur.left==null&&cur.right==null||(pre!=null&&(pre==cur.left||pre==cur.right))){//deal with topological dependency
                result.add(cur.val);
                stack.pop();
                pre=cur;
            }else {
                if (cur.right!=null){
                    stack.push(cur.right);
                }
                if(cur.left!=null){
                    stack.push(cur.left);
                }
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal2(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            while (!isLeaf(cur)) {
                s.push(cur);
                cur = cur.left;
            }
            if (cur != null){
                ans.add(cur.val);
            }
            while (!s.isEmpty() && cur == s.peek().right) {
                cur = s.pop();
                ans.add(cur.val);
            }
            cur = s.isEmpty()?null:s.peek().right;
        }

        return ans;
    }

    private boolean isLeaf(TreeNode r) {
        if (r == null) return true;
        return r.left == null && r.right == null;
    }


    public List<Integer> postorderTraversal3(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode cur = s.pop();
            ans.add(0,cur.val);
            if(cur.left!=null) s.push(cur.left);
            if(cur.right!=null) s.push(cur.right);
        }
        return ans;
    }

    public List<Integer> postorderTraversal4(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }

    public List<Integer> postorderTraversal5(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode node = s.pop();
            if(node!=null){
                s.push(node);
                s.push(null);
                if(node.right!=null) s.push(node.right);
                if(node.left!=null) s.push(node.left);
            }else{
                ans.add(s.pop().val);
            }

        }
        return ans;
    }

}
