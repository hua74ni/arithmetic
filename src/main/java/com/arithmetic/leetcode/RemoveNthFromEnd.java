package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: RemoveNthFromEnd
 * @Description: 19. 删除链表的倒数第N个节点
 * @Author: huangdh
 * @Date: 2020/1/15 下午3:40
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> listNodes = new ArrayList<>();
        ListNode root = head;

        while (head != null) {
            listNodes.add(head);
            head = head.next;
        }

        ListNode removeListNode = listNodes.get(listNodes.size() - n);
        if (removeListNode == root) {
            return root.next;
        } else {
            ListNode preNode = listNodes.get(listNodes.size() - n - 1);
            preNode.next = removeListNode.next;
        }

        return root;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);

//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode result = new RemoveNthFromEnd().removeNthFromEnd(listNode1,1);

        while (result != null) {
            System.out.print(result + "->");
            result = result.next;
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

}
