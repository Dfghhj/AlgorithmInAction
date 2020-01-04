package top.dfghhj.leetCode.list;

/**
 * 707.设计链表
 */
public class MyLinkedList {

    private Node node;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.node = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        int k = 0;
        Node node = this.node;
        while (node != null) {
            if(k == index) {
                return node.val;
            }
            node = node.next;
            k++;
        }
        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (this.node == null) {
            this.node = new Node(val);
        } else {
            Node head = new Node(val);
            head.next = this.node;
            this.node = head;
        }
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node tail = this.node;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = new Node(val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        int k = 0;
        Node before = null;
        Node now = this.node;
        while (now != null || k == index) {
            if (k == index) {
                Node newNode = new Node(val);
                newNode.next = now;
                if (before == null) {
                    this.node = newNode;
                } else {
                    before.next = newNode;
                }
                return;
            } else {
                before = now;
                now = now.next;
                k++;
            }
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        int k = 0;
        Node before = null;
        Node node = this.node;
        while (node != null) {
            if (k == index) {
                if (before != null) {
                    before.next = node.next;
                } else {
                    this.node = node.next;
                }
                return;
            } else {
                before = node;
                node = node.next;
                k++;
            }
        }
    }

    static class Node {
        int val;

        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
