package main.java.solutions.tree;

import java.util.HashMap;
import java.util.Map;

import main.java.structure.TreeNode;

public class PathSum437 {
	/*
	You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
	 */
	public int pathSum(TreeNode root,int sum){
		Map<Integer,Integer> preSum = new HashMap<>();
		preSum.put(0, 1);
		return traverse(root,preSum,0,sum);
	}
	
	public int traverse(TreeNode root,Map<Integer,Integer> preSum,int curSum,int target){
		if(root==null){
			return 0;
		}
		curSum += root.val;
		int res = preSum.getOrDefault(curSum-target, 0);
		preSum.put(curSum, preSum.getOrDefault(curSum, 0)+1);
		int left = traverse(root.left,preSum,curSum,target);
		int right = traverse(root.right,preSum,curSum,target);
		preSum.put(curSum, preSum.get(curSum)-1);
		return res+left+right;
	}
	
	public int pathSum2(TreeNode root,int sum){
		if(root==null) return 0;
		return pathSumFrom(root,sum,0)+pathSum2(root.left,sum)+pathSum2(root.right,sum);
	}
	
	public int pathSumFrom(TreeNode root,int target,int currSum){
		if(root==null) return 0;
		currSum+=root.val;
		return (currSum==target?1:0)+pathSumFrom(root.left,target,currSum)+pathSumFrom(root.right,target,currSum);
	}
}
