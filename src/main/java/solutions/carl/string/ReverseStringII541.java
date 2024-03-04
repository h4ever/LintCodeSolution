package solutions.carl.string;

public class ReverseStringII541 {
    /*
    给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。

    如果剩余字符少于 k 个，则将剩余字符全部反转。
    如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。


    示例 1：

    输入：s = "abcdefg", k = 2
    输出："bacdfeg"
    示例 2：

    输入：s = "abcd", k = 2
    输出："bacd"


    提示：

    1 <= s.length <= 10^4
    s 仅由小写英文组成
    1 <= k <= 10^4
     */
    public String reverseStr(String s, int k) {
        System.out.println(s.length());
        int groups = s.length()/k;
        char[] characterSequence = s.toCharArray();
        int i=0;
        for(;i<=groups;i++){
            if(i%2==0){
                System.out.println((i+1)*k);
                if((i+1)*k<s.length()){
                    reverseStr(characterSequence,i*k,(i+1)*k-1);
                }else{
                    reverseStr(characterSequence,i*k,s.length()-1);
                }

            }
        }

        return String.valueOf(characterSequence);
    }

    public void reverseStr(char[] characterSequence, int begin, int end){
        while(begin<end){
            char temp = characterSequence[begin];
            characterSequence[begin] = characterSequence[end];
            characterSequence[end] = temp;
            begin++;
            end --;
        }
    }
    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i< ch.length; i += 2 * k) {
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {
                reverseStr(ch, i, i + k -1);
            }else{
                // 3. 剩余字符少于 k 个，则将剩余字符全部反转
                reverseStr(ch, i, ch.length - 1);
            }
        }
        return  new String(ch);
    }


    public static void main(String[] args) {
        ReverseStringII541 reverseStringII541 = new ReverseStringII541();
        System.out.println(reverseStringII541.reverseStr("abcdefghijkl",4));
    }
}
