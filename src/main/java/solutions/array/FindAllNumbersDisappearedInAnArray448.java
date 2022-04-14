package solutions.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray448 {
    /*
    Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> giant = new HashSet<>();
        for(int num : nums){
            giant.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=nums.length;i++){
            if(!giant.contains(i)) ans.add(i);
        }
        return  ans;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int len = nums.length;
        for(int i=0;i<nums.length;i++){
            int ii = (nums[i]-1)%len;
            nums[ii] += len;
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=len) ans.add(i+1);
        }
        return  ans;
    }
}
