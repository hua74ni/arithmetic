package com.arithmetic.leetcode;

/**
 * @Author huangdh
 * @Description 两数相加
 **/
public class TwoListNodeSum {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode root = null;
        ListNode pre = null;
        ListNode node;
        int sum = 0;
        int carry = 0;

        while (l1 != null || l2 != null) {

            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (sum >= 10) {
                carry = sum / 10;
                sum = sum % 10;
            } else {
                carry = 0;
            }

            if (pre == null) {
                root = new ListNode(sum);
                pre = root;
            } else {
                node = new ListNode(sum);
                pre.next = node;
                pre = node;
            }
        }

        if (carry != 0) {
            node = new ListNode(carry);
            pre.next = node;
        }

        return root;
    }

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(2);
//        ListNode l11 = new ListNode(4);
//        ListNode l111 = new ListNode(3);
//        ListNode l2 = new ListNode(5);
//        ListNode l22 = new ListNode(6);
//        ListNode l222 = new ListNode(4);
//
//        l1.next = l11;
//        l11.next = l111;
//
//        l2.next = l22;
//        l22.next = l222;

        ListNode l1 = new ListNode(1);
        ListNode l11 = new ListNode(8);
        ListNode l2 = new ListNode(0);

        l1.next = l11;

        ListNode result = addTwoNumbers(l1, l2);

        while (result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

//        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 0 -> 8
//        原因：342 + 465 = 807

    }


}
