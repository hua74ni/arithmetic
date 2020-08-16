package com.arithmetic.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Flatten {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new ArrayDeque();
        Stack<TreeNode> stack = new Stack();
        stack.add(root);
        for (; !stack.isEmpty(); ) {
            TreeNode current = stack.pop();
            while (current.left != null) {
                stack.add(current);
                queue.add(current.left);
                TreeNode next = current.left;
                current.left = null;
                current = next;
            }
            if (current.right != null) {
                queue.add(current.right);
                stack.add(current.right);
            }
        }

        while (!queue.isEmpty()) {
            root.right = queue.poll();
            root = root.right;
        }
    }


    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);

        root1.left = root2;
        root1.right = root5;
        root2.left = root3;
        root2.right = root4;
        root5.left = root6;
        root5.right = root7;

        new Flatten().flatten(root1);

        for (; root1 != null; ) {
            System.out.println(root1.val);
            root1 = root1.right;
        }
    }

}
