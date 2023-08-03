package solutions.top100liked;

import java.util.HashSet;
import java.util.List;

public class WordBreak139 {
    /**
     Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

     Note that the same word in the dictionary may be reused multiple times in the segmentation.
     */

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return wordBreak(s,set);
    }

    public boolean wordBreakTLE(String s, HashSet<String> set){
        if(s==null||s.length()==0){
            return true;
        }

        for(int i=1;i<=s.length();i++){
            if(set.contains(s.substring(0,i))&&wordBreak(s.substring(i),set)){
                return true;
            }

        }
        return false;
    }

    public static boolean wordBreak(String s, HashSet<String> set){
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(canBreak[j]&&set.contains(s.substring(j,i))){
                    canBreak[i]=true;
                    break;
                }
            }
        }
        return canBreak[s.length()];
    }

    public static boolean wordBreak2(String s, HashSet<String> set){
        boolean[] canBreak = new boolean[s.length()+1];
        canBreak[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(String str: set){
                if(str.length() <= i){
                    int j = i - str.length();
                    if(canBreak[j] && s.startsWith(str, j)){
                            canBreak[i] = true;
                            break;
                    }
                }
            }
        }
        return canBreak[s.length()];
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("cats");
        set.add("dog");
        set.add("sand");
        set.add("and");
        set.add("cat");
        set.add("an");
        set.add("og");
        String s = "catsandog";
        System.out.println(wordBreak2(s,set));

    }
}

