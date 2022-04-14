package solutions.tree;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIVInputBST653 {
    /*
    Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
     */
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        for(int i=0,j=list.size()-1;i<j;){
            if(list.get(i)+list.get(j)==k) return true;
            if(list.get(i)+list.get(j)<k){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

    public void inorder(TreeNode root,List<Integer> sorted){
        if(root==null) return;
        inorder(root.left,sorted);
        sorted.add(root.val);
        inorder(root.right,sorted);
    }
}
