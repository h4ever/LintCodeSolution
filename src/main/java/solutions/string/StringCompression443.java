package solutions.string;

import java.util.Arrays;

public class StringCompression443 {
    public static int compress(char[] chars) {
        if(chars==null||chars.length==0) return 0;
        int indexAns=0;
        for(int i=0;i<chars.length;){
            char curr = chars[i];
            int cnt=1;
            int j=i+1;
            while(j<chars.length&&chars[j]==curr) {cnt++;j++;}
            chars[indexAns] = curr;
            if(cnt>1){
                for(char ch:Integer.toString(cnt).toCharArray()){
                    chars[++indexAns] = ch;
                }
            }
            i=j;
        }
        return indexAns;
    }

    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        int x = compress(chars);
        System.out.println(x);
        System.out.println(Arrays.toString(chars));
    }
}
