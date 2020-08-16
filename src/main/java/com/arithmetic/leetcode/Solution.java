package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode rs = head;
        List<ListNode> list = new ArrayList<>();
        ListNode index = head;
        while (index != null) {
            list.add(index);
            index = index.next;
        }
        int max = 1;
        int i = 1;
        ListNode current = list.get(i);

        while (current != null) {
            ListNode listNode = rs;
            ListNode listNodePre = null;
            int size = 0;
            while (listNode != null && size != max) {
                if (listNode.val > current.val) {
                    // head
                    if (listNode == rs) {
                        current.next = rs;
                        rs = current;
                        break;
                    } else {
                        current.next = listNode;
                        listNodePre.next = current;
                        break;
                    }
                } else if (size == max - 1) {
                    listNode.next = current;
                    break;
                }
                size++;
                listNodePre = listNode;
                listNode = listNode.next;
            }
            i++;
            max++;
            if (i == list.size()) break;
            current = list.get(i);
        }

        index = rs;
        int size = 1;
        while (index != null && size != list.size()) {
            index = index.next;
            size++;
        }
        index.next = null;
        return rs;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(5);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(-1);
        ListNode head4 = new ListNode(9);
        ListNode head5 = new ListNode(2);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        ListNode rs = new Solution().insertionSortList(head1);
        while (rs != null) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }
}
