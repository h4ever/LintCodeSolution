package solutions.string;

public class AddStrings415 {
    /*
    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

    The length of both num1 and num2 is < 5100.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.

     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        int carry = 0;
        int i1 = chs1.length-1,i2=chs2.length-1;
        while(i1>=0&&i2>=0){
            int sum = (chs1[i1--]-'0')+(chs2[i2--]-'0') + carry;
            res.append(sum %10);
            carry = sum/10;
        }
        while(i1>=0){
            int sum = (chs1[i1--]-'0') + carry;
            res.append(sum %10);
            carry = sum/10;
        }
        while(i2>=0){
            int sum = (chs2[i2--]-'0') + carry;
            res.append(sum %10);
            carry = sum/10;
        }
        if(carry==1) res.append("1");
        return res.reverse().toString();
    }
}
