package solutions.carl.tree;

import structure.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PopulatingNextRightPointersInEachNode116 {
    /*
        给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

        struct Node {
          int val;
          Node *left;
          Node *right;
          Node *next;
        }
        填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

        初始状态下，所有 next 指针都被设置为 NULL。


     */

    //一份代码同样可以解决117题
    public TreeLinkNode connect(TreeLinkNode root) {
        TreeLinkNode p = root;
        if(root==null) return p;
        Deque<TreeLinkNode> q = new ArrayDeque<>();
        q.offer(p);
        while(!q.isEmpty()){

            int size = q.size();
            TreeLinkNode preNode = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = q.poll();
                if(preNode==null){
                    preNode = node;
                }else{
                    preNode.next = node;
                    preNode = node;
                }
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }

        }
        return root;
    }
}
