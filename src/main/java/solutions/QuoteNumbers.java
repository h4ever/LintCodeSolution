package solutions;

import java.util.Scanner;

public class QuoteNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(quoteNumbers(sc.next()));
        }
    }
    private static String quoteNumbers(String s){
        StringBuilder sb = new StringBuilder();
        boolean preDigit = false;
        for(int i=0;i<s.length();i++){
            if(!Character.isDigit(s.charAt(i))){
                if(preDigit) sb.append("*");
                preDigit = false;
            }else{
                if(!preDigit) sb.append("*");
                preDigit = true;
            }
            sb.append(s.charAt(i));
        }
        if(preDigit) sb.append("*");
        return sb.toString();
    }


}
