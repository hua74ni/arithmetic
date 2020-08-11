package com.arithmetic.swordo;

/**
 * 22. 链表中倒数第k个节点
 */
public class GetKthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode res = head;
        int num = 0;
        ListNode current = head;
        while (current != null) {
            if (num == k) {
                res = res.next;
            } else {
                num++;
            }
            current = current.next;
        }
        return res;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        ListNode head4 = new ListNode(5);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ListNode res = new GetKthFromEnd().getKthFromEnd(head, 2);

        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }

}
