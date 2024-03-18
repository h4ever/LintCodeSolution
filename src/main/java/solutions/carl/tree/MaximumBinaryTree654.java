package solutions.carl.tree;

import structure.TreeNode;

public class MaximumBinaryTree654 {
    /*
        给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:

        创建一个根节点，其值为 nums 中的最大值。
        递归地在最大值 左边 的 子数组前缀上 构建左子树。
        递归地在最大值 右边 的 子数组后缀上 构建右子树。
        返回 nums 构建的 最大二叉树 。
     */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums,0,nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int begin, int end) {
        if(begin>= end){
            return null;
        }
        int max = -1;
        int i = begin,j = 0;
        for (; i < end; i++) {
            if(nums[i]>max){
                max = nums[i];
                j = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums,begin,j);
        root.right = constructMaximumBinaryTree(nums,j+1,end);
        return root;

    }
}
