package solutions.carl.string;

public class RightOpString {

    public static String rightOp(String s,int k){
        if(k>s.length()){
            return s;
        }
        return s.substring(s.length()-k)+s.substring(0,s.length()-k);
    }

    public static void main(String[] args) {
        System.out.println(rightOp("abcdefgf".toCharArray(),3));
        System.out.println(leftOp("abcdefgf".toCharArray(),3));
    }

    public static char[] rightOp(char[] s,int k){
        if(k>s.length){
            return s;
        }
        reverse(s,0,s.length-1);
        reverse(s,0,k-1);
        reverse(s,k,s.length-1);

        return s;
    }

    public static char[] leftOp(char[] s,int k){
        if(k>s.length){
            return s;
        }
        reverse(s,0,s.length-1);
        reverse(s,0,s.length-k-1);
        reverse(s,s.length-k,s.length-1);
        return s;
    }


    public static void reverse(char[] s,int begin,int end){
        if(begin<0||end>=s.length){
            return;
        }

        while(begin<end){
            char tmp = s[begin];
            s[begin++] = s[end];
            s[end--] = tmp;
        }

    }


}
