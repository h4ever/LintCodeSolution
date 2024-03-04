package solutions.carl.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation150 {

    /*
    给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。

请你计算该表达式。返回一个表示表达式值的整数。

注意：

有效的算符为 '+'、'-'、'*' 和 '/' 。
每个操作数（运算对象）都可以是一个整数或者另一个表达式。
两个整数之间的除法总是 向零截断 。
表达式中不含除零运算。
输入是一个根据逆波兰表示法表示的算术表达式。
答案及所有中间计算结果可以用 32 位 整数表示。

     */
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if(token.equals("+")){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String res = String.valueOf(Integer.parseInt(op1)+Integer.parseInt(op2));
                stack.push(res);
            }else if(token.equals("-")){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String res = String.valueOf(Integer.parseInt(op2)-Integer.parseInt(op1));
                stack.push(res);
            }else if(token.equals("*")){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String res = String.valueOf(Integer.parseInt(op2)*Integer.parseInt(op1));
                stack.push(res);
            }else if(token.equals("/")){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String res = String.valueOf(Integer.parseInt(op2)/Integer.parseInt(op1));
                stack.push(res);
            }else{
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }


}
