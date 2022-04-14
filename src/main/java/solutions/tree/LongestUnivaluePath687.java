package solutions.tree;

import structure.TreeNode;

public class LongestUnivaluePath687 {
    /*
    Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.
     */

    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return ans;
    }
    /*
      Basically, if every node can tell how far the path from it can extend on the left and on the right, we are done!
As part of traversal of the tree, we touch every node so we can keep updating max with that answer at each node.
Now, what do we mean by extending? Simply compare the values of the current node and its children. Then any path starting at the child can be extended to our node.

    If we cannot extend our path either to left or right, we simply return 0.
    If we can extend only one side, we add 1 to that side path and return to the caller.
    If we can extend to both sides, max will be the total path extended to the left side and right side combined. But to our caller, we just pick the max of the two sides and return.

     */

    // return the longest univalue length from root node  ,the same value is root.val
    public int dfs(TreeNode root){
        if(root==null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        if(root.left!=null&&root.val==root.left.val) l+=1;
        else l=0;
        if(root.right!=null&&root.val==root.right.val) r+=1;
        else r = 0;
        ans = Math.max(ans,l+r);
        return Math.max(l,r);
    }
}
