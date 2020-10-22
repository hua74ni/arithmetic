package com.arithmetic.leetcode;

import java.util.HashSet;

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
        HashSet<Integer> set = new HashSet();
        ListNode res = head;
        ListNode pre = head;
        set.add(head.val);
        head = head.next;
        while (head != null) {
            if (!set.contains(head.val)) {
                pre.next = head;
                pre = head;
                set.add(head.val);
            }
            head = head.next;
        }
        pre.next = null;
        return res;
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
