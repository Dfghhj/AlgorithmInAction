package top.dfghhj.leetCode.stack;

import java.util.Stack;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/23 21:21
 * @Description:
 * 根据逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 *   整数除法只保留整数部分。
 *   给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例：
 *   输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 *   输出: 22
 *   解释:
 *     ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 *   = ((10 * (6 / (12 * -11))) + 17) + 5
 *   = ((10 * (6 / -132)) + 17) + 5
 *   = ((10 * 0) + 17) + 5
 *   = (0 + 17) + 5
 *   = 17 + 5
 *   = 22
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
