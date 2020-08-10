package com.arithmetic.leetcode;

/**
 * @Author huangdh
 * @Description 18. 删除链表的节点
 **/
public class DeleteNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            head = head.next;
            return head;
        }

        ListNode pre = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.val == val) {
                pre.next = current.next;
                break;
            }
            pre = current;
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(9);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        ListNode root = new DeleteNode().deleteNode(head, 4);

        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

}
