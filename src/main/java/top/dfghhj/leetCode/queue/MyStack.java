package top.dfghhj.leetCode.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Dfghhj
 * @Date: 2019/12/11 20:34
 * @Description: 225. 用队列实现栈
 */
public class MyStack {

    private Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MyStack() {
        deque = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (deque.isEmpty()) {
            return -1;
        } else {
            Integer result = deque.getLast();
            deque.removeLast();
            return result;
        }
    }

    /** Get the top element. */
    public int top() {
        if (deque.isEmpty()) {
            return -1;
        } else {
            return deque.getLast();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}
