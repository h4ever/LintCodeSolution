package solutions.carl.hashtable;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242 {
    /*
        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

            注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。



        示例 1:

        输入: s = "anagram", t = "nagaram"
        输出: true
        示例 2:

        输入: s = "rat", t = "car"
        输出: false


        提示:

        1 <= s.length, t.length <= 5 * 104
        s 和 t 仅包含小写字母
     */

    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
         }

        Map<Character,Integer> mapS = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            mapS.put(c,mapS.getOrDefault(c,0)+1);
        }

        for (char c : t.toCharArray()) {
            if(!mapS.containsKey(c)){
                return false;
            }else{
                mapS.put(c,mapS.get(c)-1);
            }
        }

        for (Map.Entry<Character, Integer> characterIntegerEntry : mapS.entrySet()) {
            if(characterIntegerEntry.getValue()!=0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagram2(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        int[] st = new int[26];

        for (char c : s.toCharArray()) {
            st[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            st[c-'a']--;
        }

        for (int i : st) {
            if(i!=0){
                return  false;
            }
        }

        return true;
    }
}
