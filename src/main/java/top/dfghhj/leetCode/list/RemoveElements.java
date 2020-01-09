package top.dfghhj.leetCode.list;

/**
 * 203. 移除链表元素
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode beforeNode = null;
        ListNode nowNode = head;
        ListNode afterNode = null;
        while (nowNode != null) {
            afterNode = nowNode.next;
            if (nowNode.val == val) {
                if (beforeNode != null) {
                    beforeNode.next = afterNode;
                } else {
                    head = afterNode;
                }
            } else {
                beforeNode = nowNode;
            }
            nowNode = afterNode;
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
