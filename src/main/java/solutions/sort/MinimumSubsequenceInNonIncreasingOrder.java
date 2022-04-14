package solutions.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubsequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum() , sumIter = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i=nums.length-1;i>-1;i--){
            sumIter += nums[i];
            ans.add(nums[i]);
            if(sumIter>sum-sumIter)  break;
        }
        return ans;
    }
}
