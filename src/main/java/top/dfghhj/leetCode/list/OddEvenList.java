package top.dfghhj.leetCode.list;

/**
 * 328. 奇偶链表
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        int i = 0;
        ListNode before = null;
        ListNode now = head;
        ListNode evenLast = head;
        while (now != null) {
            if (i%2==0 && i > 0) {
                before.next = now.next;
                now.next = evenLast.next;
                evenLast.next = now;
                evenLast = now;
                now = before.next;
            } else {
                before = now;
                now = now.next;
            }
            i++;
        }
        return head;
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
