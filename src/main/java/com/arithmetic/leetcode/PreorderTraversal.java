package com.arithmetic.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: PreorderTraversal
 * @Description: 144. 二叉树的前序遍历
 * @Author: huangdh
 * @Date: 2020/7/29 上午9:58
 */
public class PreorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);

        root.right = root1;
        root1.left = root2;

        new PreorderTraversal().preorderTraversal(root).forEach(System.out::println);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode current = stack.pop();
            list.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return list;
    }

}
