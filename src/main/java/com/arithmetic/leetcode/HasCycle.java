package com.arithmetic.leetcode;

import java.util.HashMap;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: HasCycle
 * @Description: 141. 环形链表
 * @Author: huangdh
 * @Date: 2020/7/28 上午10:49
 */
public class HasCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        HashMap<ListNode, ListNode> hashMap = new HashMap();
        for (;head != null;head = head.next) {
            ListNode listNode = hashMap.get(head);
            if (listNode != null) return listNode;
            hashMap.put(head, head);
        }
        return null;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);

        head.next = head1;
        head1.next = head;

        System.out.println(new HasCycle().detectCycle(head).val);
    }

}
