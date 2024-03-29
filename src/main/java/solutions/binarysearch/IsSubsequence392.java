package solutions.binarysearch;

public class IsSubsequence392 {
    /*
     Given a string s and a string t, check if s is subsequence of t.

You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
     */

    public static boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        int idxTrace = -1;
        for(char ch:sArr){
            idxTrace = t.indexOf(ch,idxTrace+1);
            if(idxTrace==-1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        isSubsequence("abc","ahbgdc");
    }
}
