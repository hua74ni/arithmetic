package com.arithmetic.leetcode;

public class ReverseLinked {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    public ListNode reverseLinked(ListNode head) {
//        ListNode pre = null;
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = pre;
//            pre = head;
//            head = next;
//        }
//        return pre;
//    }

    public ListNode reverseLinked(ListNode head) {
        return trace(head);
    }

    private ListNode trace(ListNode head) {
        if (head == null) return null;
        head.next = trace(head.next);
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

        ListNode rs = new ReverseLinked().reverseLinked(head1);

        while (rs != null) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }

}
