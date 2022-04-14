package solutions.array;

import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter1170 {
    /*
    Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
Constraints:

    1 <= queries.length <= 2000
    1 <= words.length <= 2000
    1 <= queries[i].length, words[i].length <= 10
    queries[i][j], words[i][j] are English lowercase letters.

     */
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
