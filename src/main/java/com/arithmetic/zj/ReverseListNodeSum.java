package com.arithmetic.zj;

/**
 * 用单向链表表示十进制整数，求两个整数的和，请注意单向链表的方向，不允许使用其他数据结构
 * <p>
 * 例如：
 * 链表:1->2->3->4->null + 3->4->null
 * 那么 1->2->6->8->null
 */
public class ReverseListNodeSum {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseListNodeSum(ListNode left, ListNode right) {
        left = reverseListNode(left);
        right = reverseListNode(right);

        int plus = 0;
        ListNode head = new ListNode(-1);
        ListNode root = head;
        while (left != null && right != null) {
            int sum = left.val + right.val + plus;
            if (sum >= 10) {
                plus = 1;
                sum = sum - 10;
            } else {
                plus = 0;
            }
            ListNode cur = new ListNode(sum);
            head.next = cur;
            head = head.next;
            left = left.next;
            right = right.next;
        }
        if (left != null) next(left, head, plus);
        if (right != null) next(right, head, plus);
        root = reverseListNode(root.next);
        return root;
    }

    private void next(ListNode root, ListNode head, int plus) {
        while (root != null) {
            int sum = root.val + plus;
            if (sum == 10) {
                plus = 1;
                sum = sum - 10;
            } else {
                plus = 0;
            }
            ListNode cur = new ListNode(sum);
            head.next = cur;
            head = head.next;
            root = root.next;
        }
        if (plus == 1) {
            ListNode cur = new ListNode(1);
            head.next = cur;
            head = head.next;
            plus = 0;
        }
    }

    private ListNode reverseListNode(ListNode root) {
        ListNode pre = null;
        while (root != null) {
            ListNode next = root.next;
            root.next = pre;
            pre = root;
            root = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode left = new ListNode(9);
        ListNode left1 = new ListNode(9);
        ListNode left2 = new ListNode(5);
        ListNode left3 = new ListNode(5);

        left.next = left1;
        left1.next = left2;
        left2.next = left3;

        ListNode right = new ListNode(5);
        ListNode right1 = new ListNode(5);
        right.next = right1;

        ListNode res = new ReverseListNodeSum().reverseListNodeSum(left, right);
        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }
}
