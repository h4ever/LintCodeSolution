package solutions.tree;

import structure.TreeNode;

import java.util.*;

public class AllNodesDistanceKInBinaryTree863 {
    /*
    We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
     */
    public static Map<TreeNode, Integer> map = new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        find(root, target);
        dfs(root, K, 0, res);
        return res;
    }


    public static List<Integer> distanceK2(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new LinkedList<>();
        Map<TreeNode,TreeNode> par = new HashMap<>();
        dfs(root,null,par);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);seen.add(null);
        int dist = 0;
        while(!q.isEmpty()){
            if(dist==K){
                while(!q.isEmpty()){
                    res.add(q.poll().val);
                }
                return res;
            }
            int size = q.size();
            while(size-->0){
                TreeNode p = q.poll();
                expand(p.left,seen,q);
                expand(p.right,seen,q);
                expand(par.get(p),seen,q);
            }
            dist++;
        }

        return res;
    }

    public static void expand(TreeNode root,Set<TreeNode> seen,Queue<TreeNode> q){
        if(root!=null&&!seen.contains(root)){
            seen.add(root);
            q.offer(root);
        }
    }

    public static void dfs(TreeNode root,TreeNode parent,Map<TreeNode,TreeNode> par){
        if(root!=null){
            par.put(root,parent);
            dfs(root.left,root,par);
            dfs(root.right,root,par);
        }
    }


    // find target node first and store the distance in that path that we could use it later directly
    private static int find(TreeNode root, TreeNode target) {
        if (root == null) return -1;
        if (root == target) {
            map.put(root, 0);
            return 0;
        }
        int left = find(root.left, target);
        if (left >= 0) {
            map.put(root, left + 1);
            return left + 1;
        }
        int right = find(root.right, target);
        if (right >= 0) {
            map.put(root, right + 1);
            return right + 1;
        }
        return -1;
    }

    private static void dfs(TreeNode root, int K, int dis, List<Integer> res) {
        if (root == null) return;
        if (map.containsKey(root)) dis = map.get(root);
        if (dis == K) res.add(root.val);
        dfs(root.left, K, dis + 1, res);
        dfs(root.right, K,dis + 1, res);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t4 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        TreeNode t6 = new TreeNode(6);
        TreeNode t3 = new TreeNode(3);
        TreeNode t5 = new TreeNode(5);
        TreeNode t8 = new TreeNode(8);
        TreeNode t12 = new TreeNode(12);
        TreeNode t20 = new TreeNode(20);
        TreeNode t10 = new TreeNode(10);
        TreeNode t19 = new TreeNode(19);
        t1.left = t2;
        t1.right = t4;
        t2.left = t7;
        t2.right = t6;
        t4.left = t3;
        t4.right = t5;
        t3.left = t8;
        t3.right = t12;
        t5.right = t20;
        t12.left = t10;
        t12.right = t19;

        List<Integer> ans = distanceK2(t1,t3,2);
        System.out.println(ans);
    }
}
