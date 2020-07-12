package main.java.solutions.hashtable;

public class IsomorphicStrings205 {
    /*
    Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
     */
    public static boolean isIsomorphic(String s, String t) {
        int schs[] = new int[256], tchs[] = new int[256], len = s.length();
        for (int i = 0; i < len; ++i) {
            if (schs[s.charAt(i)] != tchs[t.charAt(i)]) return false;
            schs[s.charAt(i)] = i + 1;
            tchs[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        isIsomorphic("ab","ca");
    }

}
