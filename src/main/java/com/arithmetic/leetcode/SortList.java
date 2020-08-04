package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: SortList
 * @Description: 148. 排序链表
 * @Author: huangdh
 * @Date: 2020/7/31 下午2:49
 */
public class SortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(-1);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(0);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode res = new SortList().sortList(listNode1);

        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode show = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            show = show.next;
        }
        ListNode right = show.next;
        show.next = null;
        ListNode left = sortList(head);
        right = sortList(right);

        ListNode h = new ListNode(0);
        ListNode current = h;
        while (left != null && right != null) {
            if (left.val > right.val) {
                current.next = right;
                right = right.next;
            } else {
                current.next = left;
                left = left.next;
            }
            current = current.next;
            if (right == null) current.next = left;
            if (left == null) current.next = right;
        }
        return h.next;
    }


}
