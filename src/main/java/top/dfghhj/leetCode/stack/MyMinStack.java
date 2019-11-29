package top.dfghhj.leetCode.stack;

import java.util.Stack;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/15 21:11
 * @Description:
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class MyMinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.push(2147483647);
        System.out.println(minStack.top());
        System.out.println( minStack.getMin());
        minStack.push(-2147483648);
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}

class MinStack {

    int min;

    Stack<Integer> minStack;

    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        this.min = -1;
        this.minStack = new Stack<>();
        this.stack = new Stack<>();
    }

    public void push(int x) {
        this.stack.push(x);
        if (this.minStack.empty() || x < min) {
            this.min = x;
        }
        this.minStack.push(min);
    }

    public void pop() {
        if (!this.minStack.empty() && !this.stack.empty()) {
            this.minStack.pop();
            this.stack.pop();
            if (!this.minStack.empty()) {
                this.min = this.minStack.peek();
            } else {
                this.min = -1;
            }
        }
    }

    public int top() {
        if (!this.stack.empty()) {
            return this.stack.peek();
        }
        return -1;
    }

    public int getMin() {
        return this.min;
    }
}
