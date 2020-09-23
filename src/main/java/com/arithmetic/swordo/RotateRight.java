package com.arithmetic.swordo;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: RotateRight
 * @Description: 61. 旋转链表
 * @Author: huangdh
 * @Date: 2020/9/23 上午9:53
 */
public class RotateRight {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        List<ListNode> listNodes = new ArrayList<>();

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            listNodes.add(cur);
            pre = cur;
            cur = cur.next;
        }
        pre.next = head;

        int maxIndex = listNodes.size() - 1;
        k = k % (maxIndex + 1);
        int headIndex = k == 0 ? 0 : maxIndex - (k - 1);
        int preIndex = headIndex == 0 ? maxIndex : headIndex - 1;

        cur = listNodes.get(headIndex);
        pre = listNodes.get(preIndex);
        pre.next = null;
        return cur;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(3);
//        ListNode listNode5 = new ListNode(4);


        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode res = new RotateRight().rotateRight(listNode1, 4);

        while (res != null) {
            System.out.print(res.val + " -> ");
            res = res.next;
        }

    }

}
