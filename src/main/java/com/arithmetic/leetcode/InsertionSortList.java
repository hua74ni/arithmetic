package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: InsertionSortList
 * @Description: 147. 对链表进行插入排序
 * @Author: huangdh
 * @Date: 2020/7/30 下午5:36
 */
public class InsertionSortList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode rs = new InsertionSortList().insertionSortList(listNode1);
        while (rs != null) {
            System.out.println(rs.val);
            rs = rs.next;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return  head;

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
                    } else if (listNode.next != null && listNode.next == current) {
                        // nothing
                        break;
                    } else {
                        current.next = listNode;
                        listNodePre.next = current;
                        break;
                    }
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

}
