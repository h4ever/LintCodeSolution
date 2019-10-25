package main.java.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsK560 {
	/*
	 * k nums[i,j]  sum  nums[0,j]
	 * preSum  key nums[0,i-1]  value frequency
	 * k = nums[i,j] = nums[0,j]-nums[0,i-1]
	 */
	
	public int subarraySum(int[] nums,int k){
		if(nums.length==0) return 0;
        Map<Integer,Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int sum=0;int count=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(preSum.containsKey(sum-k)) {
            	count+=preSum.get(sum-k);
            }
            preSum.put(sum,preSum.getOrDefault(sum,0)+1);
        }
        return count;
	}
	
	public int subarraySum2(int[] nums,int k){
		int len = nums.length;
		if(len==0) return 0;
		int [] preSum = new int[len];
		preSum[0]=nums[0];
		for(int i=1;i<len;i++){
			preSum[i] = preSum[i-1]+nums[i];
		}
		int count=0;
		for(int i=0;i<len;i++){
			if(preSum[i]==k) count++;
			for(int j=i+1;j<len;j++){
				if(preSum[j]-preSum[i]==k) count++;
			}
		}
		return count;
	}
	/*
	 * k nums[i,j]  sum  nums[0,j]
	 * preSum  key nums[0,i-1]  value i
	 * k = nums[i,j] = nums[0,j]-nums[0,i-1]
	 */
	public List<List<Integer>> subarraySum3(int[] nums,int k){
		if(nums.length==0) return null;
		List<Integer> sumKey = new ArrayList<>();
		List<Integer> index =  new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum=0;
        sumKey.add(0);
        index.add(-1);
        for(int j=0;j<nums.length;j++){
            sum+=nums[j];
            int idx = containsSum(sumKey,0,sum-k);
            while(-1!=idx){
            	List<Integer> ij = new ArrayList<>();
            	ij.add(index.get(idx)+1);
            	ij.add(j);
            	res.add(ij);
            	idx = containsSum(sumKey,idx+1,sum-k);
            }
            sumKey.add(sum);
            index.add(j);
        }
        return res;
	}
	
	public int containsSum(List<Integer> list ,int index,int value){
		for(int i=index;i<list.size();i++){
			if(list.get(i)==value){
				return i;
			}
		}
		return -1;
	}
	
}
