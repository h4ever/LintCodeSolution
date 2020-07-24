package main.java.solutions.array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters1160 {
    /*
    You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.
Note:

    1 <= words.length <= 1000
    1 <= words[i].length, chars.length <= 100
    All strings contain lowercase English letters only.

     */
    public int countCharacters(String[] words, String chars) {
        int[] counts = new int[26];
        for (char ch : chars.toCharArray()) {
            ++counts[ch - 'a'];
        }
        int res = 0;
        for (String w : words) {
            int[] wordCounts = new int[26];
            boolean done = true;
            for (char ch : w.toCharArray()) {
                int idx = ch - 'a';
                ++wordCounts[idx];
                if (wordCounts[idx] > counts[idx]) {
                    done = false;
                    break;
                }
            }
            if (done) res+=w.length();
        }
        return res;
    }

    public int countCharacters2(String[] words, String chars) {
        int ans = 0;
        Map<Character,Integer> blocks = new HashMap<>();
        for(int i=0;i<chars.length();i++){
            blocks.put(chars.charAt(i),blocks.getOrDefault(chars.charAt(i),0)+1);
        }
        for(String word : words){
            Map<Character,Integer> building = new HashMap<>();
            building.putAll(blocks);
            boolean done = true;
            for(int i=0;i<word.length();i++){
                if(!building.containsKey(word.charAt(i))||building.get(word.charAt(i))==0){
                    done = false;
                    break;
                }
                building.put(word.charAt(i),building.get(word.charAt(i))-1);
            }
            if(done) ans += word.length();
        }
        return ans;
    }
}
