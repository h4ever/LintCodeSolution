package solutions.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {
    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
     */
    public static int romanToInt(String s) {
        int ans = 0;
        Map<String, Integer> trans = new HashMap<>();
        trans.put("M", 1000);
        trans.put("D", 500);
        trans.put("C", 100);
        trans.put("L", 50);
        trans.put("X", 10);
        trans.put("V", 5);
        trans.put("I", 1);
        trans.put("IV", 4);
        trans.put("IX", 9);
        trans.put("XL", 40);
        trans.put("XC", 90);
        trans.put("CD", 400);
        trans.put("CM", 900);

        int i = 0;
        while (i < s.length() - 1) {
            if (trans.containsKey(s.substring(i, i+2))) {
                ans += trans.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += trans.get(s.substring(i, i+1));
                i++;
            }
        }
        if (i == s.length() - 1) ans += trans.get(s.substring(i, i+1));
        return ans;
    }

    public int romanToInt2(String s) {
        int[] nums = new int[s.length()];
        for(int i=0;i<nums.length;i++){
            switch(s.charAt(i)){
                case 'M':
                    nums[i]=1000;
                    break;
                case 'D':
                    nums[i]=500;
                    break;
                case 'C':
                    nums[i]=100;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'X':
                    nums[i]=10;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'I':
                    nums[i]=1;
                    break;
            }
        }
        int sum=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                sum -= nums[i];
            }else{
                sum += nums[i];
            }
        }

        return sum+nums[nums.length-1];
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
