package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: LevelOrder
 * @Description: 102. 二叉树的层序遍历
 * @Author: huangdh
 * @Date: 2020/7/15 上午10:28
 */
public class LevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        // 1 是从左往右 0是从右往左
        int index = 1;

        for (; !queue.isEmpty(); ) {
            int n = queue.size();
            List<Integer> list = new ArrayList();
            ArrayDeque<TreeNode> nextQueue = new ArrayDeque();
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.pollLast();
                if ((index & 1) == 1) {
                    if (current.left != null) nextQueue.add(current.left);
                    if (current.right != null) nextQueue.add(current.right);
                } else {
                    if (current.right != null) nextQueue.add(current.right);
                    if (current.left != null) nextQueue.add(current.left);
                }
                list.add(current.val);
            }
            index++;
            result.add(list);
            queue = nextQueue;
        }
        return result;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(20);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(7);

        root1.left = root2;
        root1.right = root3;
        root3.left = root4;
        root3.right = root5;

        List<List<Integer>> result = new LevelOrder().levelOrder(root1);

        for (List<Integer> integers : result) {
            System.out.println(JSON.toJSONString(integers));
        }
    }

}
