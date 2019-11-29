package top.dfghhj.leetCode.queue;

/**
 * @Author: Dfghhj
 * @Date: 2019/4/9 21:44
 * @Description:
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * 你的实现应该支持如下操作：
 *      MyCircularQueue(k): 构造器，设置队列长度为 k 。
 *      Front: 从队首获取元素。如果队列为空，返回 -1 。
 *      Rear: 获取队尾元素。如果队列为空，返回 -1 。
 *      enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 *      deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 *      isEmpty(): 检查循环队列是否为空。
 *      isFull(): 检查循环队列是否已满。
 * 示例：
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
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
