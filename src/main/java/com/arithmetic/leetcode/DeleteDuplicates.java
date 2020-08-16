package com.arithmetic.leetcode;

public class DeleteDuplicates {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null) {
            return null;
        }

        // 找到第一个不重复的root
        ListNode root = head;
        for (; root != null; ) {
            ListNode next = root.next;
            if (next != null && next.val == root.val) {
                for (; next != null && next.val == root.val; ) {
                    next = next.next;
                }
                root = next;
                head = next;
            } else {
                break;
            }
        }

        if (head == null) {
            return root;
        }

        ListNode pre = head;
        head = head.next;
        for (; head != null; ) {
            ListNode current = head;
            ListNode next = current.next;
            if (next != null && next.val == current.val) {
                // 找到所有相同的
                for (; next != null && next.val == current.val; ) {
                    next = next.next;
                }
                pre.next = next;
                head = next;
            } else {
                pre = current;
                head = current.next;
            }
        }

        return root;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1);
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(3);
        ListNode root3 = new ListNode(3);
        ListNode root4 = new ListNode(4);
        ListNode root5 = new ListNode(4);

        root.next = root1;
        root1.next = root2;
        root2.next = root3;
        root3.next = root4;
        root4.next = root5;

        ListNode listNode = new DeleteDuplicates().deleteDuplicates(root);
        for (; listNode != null; listNode = listNode.next) {
            System.out.println(listNode.val);
        }

    }

}
