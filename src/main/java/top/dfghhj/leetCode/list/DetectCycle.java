package top.dfghhj.leetCode.list;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {

    public static void main(String[] args) {
        DetectCycle test = new DetectCycle();
        ListNode q = new ListNode(3);
        ListNode w = new ListNode(2);
        ListNode e = new ListNode(0);
        ListNode r = new ListNode(-4);

        q.next = w;
        w.next = e;
        e.next = r;
        r.next = w;

        System.out.println(test.detectCycle(q).val);

    }
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        int k = 0;
        while (slow != fast || k == 0) {
            k++;
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
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
