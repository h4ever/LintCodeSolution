package main.java.solutions.string;

public class DecompressString282 {
    public static String DecompressString(String Message) {
        int left = -1;
        int right = -1;
        StringBuilder decompress = new StringBuilder(Message);
        for(int i=0;i<Message.length();i++){
            if(Message.charAt(i)=='['){
                left=i;
            }
            if(Message.charAt(i)==']'){
                right=i;
                break;
            }
        }

        if(left==-1) return decompress.toString();

        int idx = decompress.indexOf("|",left);
        int r = Integer.parseInt(decompress.substring(left+1,idx));
        String c = decompress.substring(idx+1,right);
        String rs = "";
        while(r-->0) rs+=c;
        decompress.replace(left,right+1,rs);
        return DecompressString(decompress.toString());
    }

    public static void main(String[] args) {
        System.out.println(DecompressString("HG[3|B[2|CA]]F"));

    }

}
