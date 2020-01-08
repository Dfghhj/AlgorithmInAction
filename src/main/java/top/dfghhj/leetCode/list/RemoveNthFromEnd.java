package top.dfghhj.leetCode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        Map<Integer, ListNode> index = new HashMap<>();
        int i = 0;
        while (head != null) {
            index.put(++i, head);
            head = head.next;
        }
        if (i == 1 && n == 1) return null;
        if (i == n) return index.get(2);
        index.get(i-n).next = index.get(i-n+2);
        return index.get(1);
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
