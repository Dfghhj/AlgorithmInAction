package top.dfghhj.leetCode.list;

/**
 * 206. 反转链表
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode newHead = head;
        while (head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = newHead;
            newHead = head.next;
            head.next = temp;
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
