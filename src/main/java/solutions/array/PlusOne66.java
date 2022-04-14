package solutions.array;

import java.util.LinkedList;
import java.util.List;

public class PlusOne66 {
    /*
    Given a non-empty array of digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.
     */
    public int[] plusOne(int[] digits) {
        int carry = 0;
        List<Integer> list = new LinkedList<>();
        for(int i=digits.length-1;i>=0;i--){
            int sum;
            if(i==digits.length-1){
                sum = digits[i]+1+carry;
            }else{
                sum = digits[i]+carry;
            }
            list.add(0,sum%10);
            carry = sum/10;
        }
        if(carry==1){
            list.add(0,1);
        }
        int[] ans = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }

    public int[] plusOne2(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits;
            }
            digits[i]=0;
        }
        int[] result = new int[digits.length+1];
        result[0]=1;
        return result;
    }
}
