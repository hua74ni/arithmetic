package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: MY
 * @Description: 有序的2个链表合并
 * @Author: huangdh
 * @Date: 2020/7/31 下午3:28
 */
public class MY {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode left = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(7);

        left.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode right = new ListNode(4);
        ListNode right2 = new ListNode(8);
        ListNode right3 = new ListNode(9);

        right.next = right2;
        right2.next = right3;


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

        h = h.next;
        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }

    }

}
