package solutions.carl.hashtable;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber202 {
    public boolean isHappy(int n) {
        Set<Integer> util = new HashSet<>();
        util.add(n);
        while(true){
            n = squareSumByDigit(n);
            if(n==1){
                return true;
            }
            if(util.contains(n)){
                return false;
            }else{
                util.add(n);
            }
        }
    }

    public int squareSumByDigit(int n){
        String a = String.valueOf(n);
        int sum = 0;
        for (char c : a.toCharArray()) {
            int digit = c-'0';
            int square = digit*digit;
            sum+=square;
        }
        return sum;
    }
}
