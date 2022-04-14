package solutions.array;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters1002 {
    /*
    Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.
Note:

    1 <= A.length <= 100
    1 <= A[i].length <= 100
    A[i][j] is a lowercase letter

     */

    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        int[][] fre = new int[A.length][26];
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[i].length();j++){
                 fre[i][A[i].charAt(j)-'a']++;
            }
        }
        for(int j=0;j<26;j++){
            int min = 101;
            for(int i=0;i<fre.length;i++){
                min = Math.min(min,fre[i][j]);
            }
            while(min-->0){
                ans.add(String.valueOf((char)('a'+j)));
            }
        }
        return ans;
    }
}
