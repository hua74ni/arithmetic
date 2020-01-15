package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MergeTwoLists
 * @Description: 21. 合并两个有序链表
 * @Author: huangdh
 * @Date: 2020/1/15 下午4:28
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode root = null;
        ListNode head = null;

        if (l1 == null && l2 == null) {
            return null;
        }

        while (l1 != null || l2 != null) {
            ListNode tmp = minNode(l1, l2);

            if (root == null) {
                root = tmp;
                head = root;
            } else {
                root.next = tmp;
                root = root.next;
            }

            if (tmp == l1) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
        }

        return head;
    }

    ListNode minNode(ListNode listNode1, ListNode listNode2) {

        if (listNode1 == null && listNode2 != null) {
            return listNode2;
        }

        if (listNode2 == null && listNode1 != null) {
            return listNode1;
        }

        if (listNode1.val >= listNode2.val) {
            return listNode2;
        } else {
            return listNode1;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "";
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(6);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(7);

        listNode1.next = listNode2;

        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode result = new MergeTwoLists().mergeTwoLists(listNode1, listNode3);

        while (result != null) {
            System.out.print(result + "->");
            result = result.next;
        }
    }

}
