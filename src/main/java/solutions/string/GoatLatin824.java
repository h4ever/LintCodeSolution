package main.java.solutions.string;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin824 {
    public String toGoatLatin(String S) {
        Set<Character> vowel = new HashSet<>();
        for (char c : "aeiouAEIOU".toCharArray()) vowel.add(c);
        String res = "";
        int i = 0, j = 0;
        for (String w : S.split("\\s")) {
            res += ' ' + (vowel.contains(w.charAt(0)) ? w : w.substring(1) + w.charAt(0)) + "ma";
            for (j = 0, ++i; j < i; ++j) res += "a";
        }
        ;
        return res.substring(1);
    }

    public String toGoatLatin2(String S) {
        String[] words =S.split("\\s");
        StringBuilder ans = new StringBuilder();
        String a = "";
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(isVowelChar(word.charAt(0))){
                word = word+"ma";
            }else{
                word = word.substring(1) + word.charAt(0) + "ma";
            }
            a += "a";
            word += a;
            ans.append(word).append(" ");
        }
        return ans.toString().trim();
    }

    public boolean isVowelChar(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        if(ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
            return true;
        }
        return false;
    }
}
