package main.java.solutions.hashtable;

import java.util.ArrayList;
import java.util.List;

public class HappyNumber202 {
    public static boolean isHappy(int n) {
        List<Integer> pows = new ArrayList<>();
        while(true){
            int afterPow = 0;
            char[] digits = String.valueOf(n).toCharArray();
            for(char digit:digits) afterPow += Math.pow(digit-'0',2);

            if(afterPow==1) return true;
            if(pows.contains(afterPow)) return false;
            pows.add(afterPow);
            n = afterPow;
        }
    }


    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
