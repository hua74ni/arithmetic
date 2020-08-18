package com.arithmetic.swordo;

import java.util.HashMap;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: CopyRandomList
 * @Description: 35. 复杂链表的复制
 * @Author: huangdh
 * @Date: 2020/8/14 上午10:29
 */
public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            Integer randomNode = this.random == null ? null : this.random.val;
            return this.val + ", " + randomNode;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            map.put(current, newNode);
            current = current.next;
        }
        current = head;
        Node resHead = new Node(-1);
        Node resCurrent = resHead;
        while (current != null) {
            resCurrent.next = map.get(current);
            resCurrent.next.random = map.get(current.random);
            current = current.next;
            resCurrent = resCurrent.next;
        }
        return resHead.next;
    }

    public static void main(String[] args) {

        Node head1 = new Node(7);
        Node head2 = new Node(13);
        Node head3 = new Node(11);
        Node head4 = new Node(10);
        Node head5 = new Node(1);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;

        head1.random = null;
        head2.random = head1;
        head3.random = head5;
        head4.random = head3;
        head5.random = head1;

        Node res = new CopyRandomList().copyRandomList(head1);

        while (res != null) {
            System.out.println(res);
            res = res.next;
        }
    }

}
