package top.dfghhj.leetCode.list;

/**
 * 234. 回文链表
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode listNode = head;
        ListNode newNode = null;
        while (listNode != null) {
            ListNode node = new ListNode(listNode.val);
            node.next = newNode;
            newNode = node;
            listNode = listNode.next;
        }
        while (newNode != null && head != null) {
            if (newNode.val != head.val) return false;
            newNode = newNode.next;
            head = head.next;
        }
        return true;
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
