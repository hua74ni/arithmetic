package com.arithmetic.leetcode;

/**
 * 24. 两两交换链表中的节点
 */
public class SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode(-1);
        ListNode h = res;
        ListNode pre = null;
        ListNode cur = null;
        ListNode next = null;
        while (head != null) {
            pre = head;
            cur = pre.next;
            next = null;
            if (cur != null) {
                next = cur.next;
            }
            if (pre != null && cur != null) {
                h.next = cur;
                h = h.next;
            }
            h.next = pre;
            h = h.next;
            head = next;
        }
        h.next = null;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        ListNode res = new SwapPairs().swapPairs(head1);

        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }

}


