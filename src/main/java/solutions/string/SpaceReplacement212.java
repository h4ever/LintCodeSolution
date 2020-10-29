package main.java.solutions.string;

public class SpaceReplacement212 {

    public static int replaceBlank(char[] string, int length) {
        // write your code here
        int count = 0;
        for(int i=0;i<length;i++){
            if(string[i]==' '){
                count++;
            }
        }
        int ans = length+count*2;
        int j=ans-1;
        for(int i=length-1;i>-1;i--){
            if(string[i]==' '){
                string[j--]='0';
                string[j--]='2';
                string[j--]='%';
            }else{
                string[j--]=string[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[] string = new char[20];
        String s = "Mr John Smith";
        for(int i=0;i<13;i++){
            string[i]=s.charAt(i);
        }

        replaceBlank(string,13);
        System.out.println(string);

    }

}
