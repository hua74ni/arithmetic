package com.arithmetic.swordo;

/**
 * 25. 合并两个排序的链表
 */
public class MergeTwoLists {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        head.next = l1 != null ? l1 : l2;
        return res.next;
    }

    public static void main(String[] args) {

        ListNode head1 = new ListNode(1);
        ListNode head11 = new ListNode(7);
        ListNode head12 = new ListNode(9);

        head1.next = head11;
        head11.next = head12;

        ListNode head2 = new ListNode(2);
        ListNode head21 = new ListNode(5);
        ListNode head22 = new ListNode(6);

        head2.next = head21;
        head21.next = head22;

        ListNode res = new MergeTwoLists().mergeTwoLists(head1, head2);

        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }

    }

}
