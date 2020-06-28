package main.java.solutions.string;

import java.util.ArrayList;
import java.util.List;

public class GreatestCommonDivisorOfStrings1071 {
    private static int gcd(int a, int b) {
        if(a==0) return b;
        else return gcd(b % a, a);
    }

    public String gcdOfStrings(String str1, String str2) {
        List<String> divisors1 = canDivide(str1);
        List<String> divisors2 = canDivide(str2);
        for(int i=0;i<divisors1.size();i++){
            for(int j=0;j<divisors2.size();j++){
                if(divisors1.get(i).equals(divisors2.get(j))) return divisors1.get(i);
            }
        }
        return "";
    }

    public List<String> canDivide(String str){
        int l = str.length();
        List<String> ans = new ArrayList<>();
        ans.add(str);
        for(int i=l/2;i>0;i--){
            if(l%i==0){
                //if(str.substring(0,i).repeat(l/i).equals(str)) ans.add(str.substring(0,i));
            }
        }
        return ans;
    }

    public String gcdOfStrings2(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        for(int i=n2; i>0; i--){
            if(n2 % i==0 && n1 % i ==0){
                String s = str2.substring(0, i);
                //if(s.repeat(n1/i).equals(str1))
                    return s;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(gcd(6,3));
    }
}
