package solutions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationNumberII40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(res,cur,candidates,0,target);
        return res;
    }

    public static void dfs(List<List<Integer>> res,List<Integer> cur,int[] candidates, int start,int target){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i=start;i<candidates.length&&target>=candidates[i];i++){
            //if(i>start&&candidates[i]==candidates[i-1]) continue;
            cur.add(candidates[i]);
            dfs(res,cur,candidates,i+1,target-candidates[i]);
            cur.remove(cur.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] cands = {1,1,1,3,3,5};
        combinationSum2(cands,8);
    }
}
