package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: ReverseBetween
 * @Description: 92. 反转链表 II
 * @Author: huangdh
 * @Date: 2020/7/9 下午6:35
 */
public class ReverseBetween {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;

        ListNode res = new ListNode(-1);
        ListNode cur = head;
        ListNode pre = null;
        int index = 1;
        while (head != null) {
            if (index == m) {
                if (index != 1) {
                    res.next = head;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
            index++;
        }

        ListNode preTail = pre;
        ListNode reverseTail = cur;
        ListNode reverseHead = null;

        pre = cur;
        cur = cur.next;
        index++;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            if (index == n) {
                reverseHead = cur;
                break;
            }
            pre = cur;
            cur = next;
            index++;
        }

        reverseTail.next = next;
        if (preTail != null) {
            preTail.next = reverseHead;
        }

        if (m == 1) {
            res.next = reverseHead;
        }
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

        ListNode res = new ReverseBetween().reverseBetween(head1, 1, 2);

        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }

}
