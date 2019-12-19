package main.java.solutions.tree;

import java.util.HashMap;
import java.util.Map;

import main.java.structure.TreeNode;

public class PathSum437 {
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
