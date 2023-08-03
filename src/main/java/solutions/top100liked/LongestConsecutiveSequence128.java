package solutions.top100liked;

import java.util.HashSet;

public class LongestConsecutiveSequence128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> u = new HashSet<>();
        for(int i:nums) u.add(i);
        int res = 0;
        for(int i:nums){
            if(!u.contains(i-1)){
                int y=i+1;
                while(u.contains(y)){
                    y++;
                }
                res = Math.max(res,y-i);
            }
        }
        return res;
    }
}
