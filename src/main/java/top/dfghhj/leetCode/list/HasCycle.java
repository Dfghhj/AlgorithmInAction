package top.dfghhj.leetCode.list;

import java.util.HashSet;
import java.util.Set;

/**
 * 141.环形链表
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.next != node && listNodeSet.contains(node)) {
                return true;
            }
            listNodeSet.add(node);
            node = node.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}