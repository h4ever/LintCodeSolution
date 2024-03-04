package solutions.carl.stack;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString1047 {
    /*
    给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     */
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        stack.push(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if(!stack.isEmpty()&&stack.peek()==chars[i]){
                stack.pop();
            }else{
                stack.push(chars[i]);
            }
        }

        String res = "";
        while(!stack.isEmpty()){
            res = stack.pop()  + res ;
        }

        return res;

    }

    public static String removeDuplicates2(String S) {
        char[] s = S.toCharArray();
        int top = -1;
        for (int i = 0; i < S.length(); i++) {
            if (top == -1 || s[top] != s[i]) {
                s[++top] = s[i];
            } else {
                top--;
            }
        }
        return String.valueOf(s, 0, top + 1);
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaac"));
    }
}
