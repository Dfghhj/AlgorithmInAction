package top.dfghhj.leetCode.stack;

import java.util.Stack;

/**
 * @Author: Dfghhj
 * @Date: 2019/12/11 20:31
 * @Description: 232.用栈实现队列
 */
public class MyQueue {
    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        } else if (stack.size() == 1) {
            return stack.pop();
        } else {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            Integer result = temp.pop();
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            return result;
        }
    }

    /** Get the front element. */
    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        } else if (stack.size() == 1) {
            return stack.peek();
        } else {
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            Integer result = temp.peek();
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            return result;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}
