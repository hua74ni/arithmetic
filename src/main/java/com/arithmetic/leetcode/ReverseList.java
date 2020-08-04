package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: ReverseList
 * @Description: 206. 反转链表
 * @Author: huangdh
 * @Date: 2020/7/31 上午9:58
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
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

        ListNode rs = new ReverseList().reverseList(head1);

        while (rs != null) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rs = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rs;
    }


}
