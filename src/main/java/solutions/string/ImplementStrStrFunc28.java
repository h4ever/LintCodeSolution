package solutions.string;

public class ImplementStrStrFunc28 {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int lens = haystack.length();
        int lent = needle.length();
        if(lens<lent) return -1;
        int scanEdge = lens-lent;
        char first = needle.charAt(0);
        for(int i=0;i<=scanEdge;i++){
            if(haystack.charAt(i)!=first){
                while (++i<=scanEdge&&haystack.charAt(i)!=first);
            }
            if(i>scanEdge) return -1;
            int j=i+1 ,end = i+lent;
            for(int k=1;j<end && haystack.charAt(j)==needle.charAt(k);k++,j++);
            if(j==end) return i;
        }
        return -1;
    }

    public int strStr3(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        int lens = haystack.length();
        int lent = needle.length();
        if(lens<lent) return -1;
        for(int i=0;i<lens-lent+1;i++){
            if(haystack.charAt(i)!=needle.charAt(0)) continue;
            int j=1,k=i+1;
            for(;j<lent&&haystack.charAt(k)==needle.charAt(j);j++,k++);
            if(j==lent) return i;
        }
        return -1;
    }

    public int strStr2(String source, String target) {
        // Write your code here
        int lens = source.length();
        int lent = target.length();
        if(lens<lent) return -1;
        if(source.equals(target)) return 0;
        for(int i=0;i<lens-lent+1;i++){
            if(source.substring(i,i+lent).equals(target)) return i;
        }
        return -1;
    }
}
