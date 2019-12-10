package top.dfghhj.leetCode.stack;

import java.util.Stack;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/23 21:21
 * @Description: 150.逆波兰表达式求值
 */
public class InversePolishExpression {

    public static void main(String[] args) {
        InversePolishExpression inversePolishExpression = new InversePolishExpression();
//        String[] tokens = {"2", "1", "+", "3", "*"};
//        String[] tokens = {"4", "13", "5", "/", "+"};
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(inversePolishExpression.evalRPN(tokens));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
                if ("+".equals(token)) {
                    int result = stack.pop() + stack.pop();
                    stack.push(result);
                } else if ("-".equals(token)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b - a;
                    stack.push(result);
                } else if ("*".equals(token)) {
                    int result = stack.pop() * stack.pop();
                    stack.push(result);
                } else if ("/".equals(token)) {
                    int a = stack.pop();
                    int b = stack.pop();
                    int result = b / a;
                    stack.push(result);
                } else {
                    stack.push(Integer.valueOf(token));
                }
        }
        return stack.pop();
    }
}
