package top.dfghhj.leetCode.queue;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/9 21:44
 * @Description: 622.设计循环队列
 */
public class CircularQueue {

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        System.out.println(circularQueue.enQueue(1));  // 返回 true
        System.out.println(circularQueue.enQueue(2));  // 返回 true
        System.out.println(circularQueue.enQueue(3));  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 false，队列已满
        System.out.println(circularQueue.Rear());  // 返回 3
        System.out.println(circularQueue.isFull());  // 返回 true
        System.out.println(circularQueue.deQueue());  // 返回 true
        System.out.println(circularQueue.enQueue(4));  // 返回 true
        System.out.println(circularQueue.Rear());  // 返回 4
    }

}

class MyCircularQueue {

    private int[] queue;

    private int length;

    private int q_start;

    private int q_end;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        length = k;
        q_start = -1;
        q_end = -1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            q_start = 0;
        }
        q_end = (q_end+1)%length;
        queue[q_end] = value;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (q_start == q_end) {
            q_start = -1;
            q_end = -1;
            return true;
        }
        q_start = (q_start+1)%length;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[q_start];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[q_end];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return q_start == -1;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return ((q_end + 1) % length) == q_start;
    }
}
