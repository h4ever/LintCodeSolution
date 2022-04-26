package solutions.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        /**
         *  map key   字符串中的字符
            map value   字符串从前到后遍历，当前遍历字符最后一次出现的位置
         *  farthestDuplicateIndex 字符串从前到后遍历，出现重复字符串最远的位置
        */
        Map<Character,Integer> m = new HashMap<>();
        int max = 0;
        for(int i=0,farthestDuplicateIndex=0;i<s.length();i++){
            char c = s.charAt(i);
            if(m.containsKey(c)){
                farthestDuplicateIndex = Math.max(farthestDuplicateIndex, m.get(c)+1);
            }
            m.put(c,i);
            max = Math.max(max,i-farthestDuplicateIndex+1);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Queue<Character> q = new LinkedList<>();
        int res = 0;
        for(char ch:s.toCharArray()){
            while(q.contains(ch)){
                q.poll();
            }
            q.offer(ch);
            res = Math.max(res,q.size());
        }

        return res;
    }
}
