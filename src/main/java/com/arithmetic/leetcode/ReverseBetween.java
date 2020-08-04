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



        return head;
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

        System.out.println(new ReverseBetween().reverseBetween(head1, 2, 4));
    }

}
