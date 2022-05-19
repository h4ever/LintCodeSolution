package solutions.top100liked;


import java.util.*;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res,new LinkedHashSet<>(),nums);
        return res;
    }

    public void backtrack(List<List<Integer>> res, Set<Integer> set,int[] nums){
        if(set.size()==nums.length){
            res.add(new ArrayList<>(set));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(set.add(nums[i])){
                backtrack(res,set,nums);
                set.remove(nums[i]);
            }
        }
    }

}
