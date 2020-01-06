package top.dfghhj.leetCode.list;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        if (headA == null || headB == null) {
//            return null;
//        }
//        ListNode nodeA = headA;
//        while (nodeA != null) {
//            ListNode nodeB = headB;
//            while (nodeB != null) {
//                if (nodeA == nodeB) {
//                    return nodeA;
//                }
//                nodeB = nodeB.next;
//            }
//            nodeA = nodeA.next;
//        }
//        return null;
//    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
