package com.arithmetic.swordo;

import java.util.*;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: ReversePrint
 * @Description: 06. 从尾到头打印链表
 * @Author: huangdh
 * @Date: 2020/8/5 下午6:41
 */
public class ReversePrint {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int [] res = new int[stack.size()];
        int i = 0;
        while (!stack.empty()) {
            res[i++] = stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        Arrays.stream(new ReversePrint().reversePrint(head)).forEach(System.out::println);
    }

}
