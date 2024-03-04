package solutions.carl.string;

import java.util.Arrays;

public class strStr28 {
    public static int[]   getNext(String needle){
        char[] chars = needle.toCharArray();
        int[] next = new int[needle.length()];
        int j = 0;
        for(int i = 1; i < chars.length; i++) {
            while (j > 0 && chars[i] != chars[j]) { // j要保证大于0，因为下面有取j-1作为数组下标的操作
                j = next[j - 1]; // 注意这里，是要找前一位的对应的回退位置了
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = getNext(needle);
        System.out.println(Arrays.toString(next));

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i))
                j = next[j - 1];
            if (needle.charAt(j) == haystack.charAt(i))
                j++;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int a = strStr("abcaaaabcaaaabcaaabcaabc","abcdaaabcdaabcdabcd");
        System.out.println(a);
    }


    public int getLongestCommonPrefixAndAffixLength(String needle) {
        int j=0;
        for(int i=1;i<needle.length();i++){
            if(needle.charAt(i)==needle.charAt(j)){
                j++;
            }else{
                j=0;
            }
        }
        return j;
    }
}
