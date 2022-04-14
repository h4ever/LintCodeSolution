package solutions.string;

import java.util.*;

public class MostCommonWord819 {
    public static String mostCommonWord(String paragraph, String[] banned) {
        int ws = 0 , max = 0;
        String ans = "";
        Map<String,Integer> fre = new HashMap<>();
        while(ws<paragraph.length()){
            if(Character.isLetter(paragraph.charAt(ws))){
                int we = ws+1;
                while(we<paragraph.length()&&Character.isLetter(paragraph.charAt(we))) we ++;
                String word = paragraph.substring(ws,we).toLowerCase();
                if(isBannedWord(word,banned)) {
                    ws = we;
                    continue;
                }
                int occurs = fre.getOrDefault(word,0)+1;
                if(occurs>max){
                    max = occurs;
                    ans = word;
                }
                fre.put(word,occurs);
                ws = we;
            }else{
                ws++;
            }
        }

        return ans;
    }

    public static boolean isBannedWord(String word,String[] banned){
        for(String bannedWord:banned){
            if(word.equals(bannedWord)){
                return true;
            }
        }
        return false;
    }

    public String mostCommonWord2(String p, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();
        String[] words = p.replaceAll("\\W+" , " ").toLowerCase().split("\\s+");
        for (String w : words) if (!ban.contains(w)) count.put(w, count.getOrDefault(w, 0) + 1);
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
    }


    public static void main(String[] args) {
        String ans = mostCommonWord("a, a, a, a, b,b,b,c, c",new String[]{"a"});
        System.out.println(ans);
    }
}
