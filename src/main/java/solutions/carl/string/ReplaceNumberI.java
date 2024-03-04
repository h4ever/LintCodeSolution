package solutions.carl.string;

public class ReplaceNumberI {
    /*
        给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。

        例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。

        对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"

        输入：一个字符串 s,s 仅包含小写字母和数字字符。

        输出：打印一个新的字符串，其中每个数字字符都被替换为了number

        样例输入：a1b2c3

        样例输出：anumberbnumbercnumber

        数据范围：1 <= s.length < 10000。
     */

    public static final String replaceStr = "number";
    public String replaceNumber(String s){
        char[] chars = s.toCharArray();
        int sum = 0;
        for (char aChar : chars) {
            if(Character.isDigit(aChar)){
                sum++;
            }
        }
        int len= s.length()+sum*replaceStr.length()-sum;
        char[] res = new char[len];
        int j = s.length()-1;
        for(int i=len-1;i>=0;){
            if(Character.isDigit(s.charAt(j))){
                i = scpStr(res,i);
            }else{
                res[i] = s.charAt(j);
                i--;
            }
            j--;
        }

        return String.valueOf(res);

    }

    public int scpStr(char[] chars, int endIndex){
        int j = replaceStr.length()-1;
        for(;j>=0;j--){
            chars[endIndex--] = replaceStr.charAt(j);
        }
        return endIndex;
    }

    public static void main(String[] args) {
        ReplaceNumberI replaceNumberI = new ReplaceNumberI();
        String a1b2c3d44 = replaceNumberI.replaceNumber("112233");
        System.out.println(a1b2c3d44);
    }
}
