package main.java.solutions.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PositionsOfLargeGroups830 {
    /*
    In a string S of lowercase letters, these letters form consecutive groups of the same character.

For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".

Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.

The final answer should be in lexicographic order.
Note:  1 <= S.length <= 1000
     */
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int startIdx = 0 , pointer = 0;
        char[] chs = S.toCharArray();
        for(;startIdx<chs.length;){
            char ch = chs[startIdx];
            pointer = startIdx+1;
            while(pointer<chs.length&&chs[pointer]==ch) pointer++;
            if(pointer-startIdx>=3){
                List<Integer> idxInfo = new ArrayList<>();
                idxInfo.add(startIdx);
                idxInfo.add(pointer-1);
                ans.add(idxInfo);
            }
            startIdx = pointer;
        }
        return ans;
    }

    public List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, j = 0; i < S.length(); i = j) {
            while (j < S.length() && S.charAt(j) == S.charAt(i)) ++j;
            if (j - i >= 3)
                res.add(Arrays.asList(i, j - 1));
        }
        return res;
    }
}
