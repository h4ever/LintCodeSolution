package main.java.solutions.array;

import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ans = new int[queries.length];
        int[] fwords = new int[words.length];

        for(int i=0;i<words.length;i++){
            fwords[i]=frequence(words[i]);
        }
        Arrays.sort(fwords);
        for(int i=0;i<queries.length;i++){
            ans[i]=getLargerCnt(frequence(queries[i]),fwords);
        }
        return ans;
    }

    public static int getLargerCnt(int fre,int[] fwords){
        int l=0;
        int r=fwords.length;
        if(fre<fwords[0]) return fwords.length;
        if(fre>=fwords[r-1]) return 0;
        while(l<r){
            int m = l + (r-l)/2;
            if(fwords[m]<=fre){
                l=m+1;
            }else{
                r=m;
            }
        }
        return fwords.length-l;
    }

    public int frequence(String word){
        char lowest = 'z';
        int freq = 0;
        for(char ch : word.toCharArray()){
            if(lowest == ch) {
                freq++;
            } else if(ch < lowest) {
                lowest = ch;
                freq = 1;
            }
        }
        return freq;
    }
}
