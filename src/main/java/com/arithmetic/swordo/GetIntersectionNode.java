package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: GetIntersectionNode
 * @Description: 52. 两个链表的第一个公共节点
 * @Author: huangdh
 * @Date: 2020/8/20 上午11:22
 */
public class GetIntersectionNode {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            curA = (curA.next == null ? headA : curA.next);
            curB = (curB.next == null ? headB : curB.next);
        }
        return curA;
    }

    public static void main(String[] args) {

        ListNode headA = new ListNode(1);
        ListNode headB = new ListNode(1);

        ListNode res = new GetIntersectionNode().getIntersectionNode(headA, headB);

        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }
    }

}
