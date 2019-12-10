package top.dfghhj.leetCode.list;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：feifeng
 * @date ：Created in 2019/4/2 12:28
 * @description: 2.两数相加
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(4);
        d.next = e;
        e.next = f;
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(JSONObject.toJSONString(addTwoNumbers.addTwoNumbers(a, d)));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> result = new ArrayList<>();
        int remainder = 0;
        int val1, val2;
        for ( int i=0 ; ; i++ ) {
            val1 = 0;
            val2 = 0;
            if (l1 != null ) {
                val1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }
            int res = (val1 + val2 + remainder) % 10 ;
            result.add(i, res);
            remainder = (val1 + val2 + remainder) / 10 ;
            if (l1 == null && l2 == null && remainder == 0) {
                break;
            }
        }
        ListNode now = null;
        ListNode before = null;
        for ( int i=result.size()-1 ; i>=0 ; i-- ) {
            now = new ListNode(result.get(i));
            now.next = before;
            before = now;
        }
        return now;
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }
}
