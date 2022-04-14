package solutions.string;

public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        char[] chs =strs[0].toCharArray();
        String ans="";
        for(int i=0;i<chs.length;i++){
            int j=1;
            while(j<strs.length){
                if(i<strs[j].length()&&strs[j].charAt(i)==chs[i]){
                    j++;
                }else break;
            }
            if(j==strs.length) ans += chs[i];
            else break;
        }
        return ans;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++){
            while(!strs[i].startsWith(pre)){
                pre = pre.substring(0,pre.length()-1);
            }
        }
        return pre;
    }
}
