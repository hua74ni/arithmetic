package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: LevelOrderBottom
 * @Description: 107. 二叉树的层次遍历 II
 * @Author: huangdh
 * @Date: 2020/7/16 上午10:44
 */
public class LevelOrderBottom {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        for (; !queue.isEmpty(); ) {
            int n = queue.size();
            Queue nextQueue = new ArrayDeque();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) nextQueue.add(current.left);
                if (current.right != null) nextQueue.add(current.right);
                list.add(current.val);
            }
            result.addFirst(list);
            queue = nextQueue;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);

        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;

        List<List<Integer>> lists = new LevelOrderBottom().levelOrderBottom(root1);
        for (List<Integer> list : lists) {
            System.out.println(JSON.toJSONString(list));
        }
    }

}
