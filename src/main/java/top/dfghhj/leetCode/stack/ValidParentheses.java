package top.dfghhj.leetCode.stack;

import java.util.Stack;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/17 22:22
 * @Description: 20.有效的括号
 */
public class ValidParentheses {

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(""));
    }

    public boolean isValid(String s) {
        if ("".equals(s)) {
            return true;
        }
        if (s != null && s.length()%2 == 1) {
            return false;
        }
        Stack<Character> before = new Stack<>();
        Stack<Character> after = new Stack<>();
        for (int i=0;i<s.length();i++) {
            before.add(s.charAt(i));
        }
        while (!before.empty()) {
            char left = before.pop();
            if (!after.empty()) {
                char right = after.peek();
                if (checkBrackets(left, right)) {
                    after.pop();
                } else {
                    after.push(left);
                }
            } else {
                after.push(left);
            }
        }
        if (before.empty() && after.empty()) {
            return true;
        }
        return false;
    }

    private boolean checkBrackets(char left, char right) {
        if ('(' == left && ')' == right) {
            return true;
        }
        if ('[' == left && ']' == right) {
            return true;
        }
        if ('{' == left && '}' == right) {
            return true;
        }
        return false;
    }
}
