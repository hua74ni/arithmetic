package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: InorderTraversal
 * @Description: 94. 二叉树的中序遍历
 * @Author: huangdh
 * @Date: 2020/7/10 上午11:04
 */
public class InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new LinkedList<>();
//        traversal(root, result);
//        return result;
//    }
//
//    private void traversal(TreeNode root, List<Integer> result) {
//        if (root != null) {
//            traversal(root.left, result);
//            result.add(root.val);
//            traversal(root.right, result);
//        }
//    }


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        Stack<TreeNode> stack = new Stack<>();
        for (; !stack.empty() || root != null; ) {
            if (root == null) {
                root = stack.pop();
            }
            for (; root != null; ) {
                if (root.left != null) {
                    TreeNode pre = root;
                    root = root.left;
                    pre.left = null;
                    stack.push(pre);
                } else {
                    break;
                }
            }
            result.add(root.val);
            if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);

        root.right = root1;
        root1.left = root2;
        System.out.println(JSON.toJSONString(new InorderTraversal().inorderTraversal(root)));
    }

}