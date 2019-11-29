package top.dfghhj.leetCode.stack;

import java.util.Stack;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/17 22:22
 * @Description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 *   输入: "()"
 *   输出: true
 * 示例 2:
 *   输入: "()[]{}"
 *   输出: true
 * 示例 3:
 *   输入: "(]"
 *   输出: false
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
