package com.arithmetic.leetcode;

import java.util.Stack;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: ReorderList
 * @Description: 143. 重排链表
 * @Author: huangdh
 * @Date: 2020/7/28 下午9:37
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        new ReorderList().reorderList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public void reorderList(ListNode head) {
        if (head == null) return;

        int length = 0;
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.add(current);
            current = current.next;
            length++;
        }
        length = length / 2;

        while (head != null) {
            if (length == 0) return;
            ListNode next = head.next;
            ListNode listNode = stack.pop();
            if (listNode == next) return;
            head.next = listNode;
            listNode.next = next;
            head = next;
            length--;
        }


    }

}
