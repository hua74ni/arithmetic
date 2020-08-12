package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: LevelOrder
 * @Description: 32 - I. 从上到下打印二叉树
 * @Author: huangdh
 * @Date: 2020/8/12 上午11:23
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

    public int[] levelOrder(TreeNode root) {
        if (root == null) return new int[0];

        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            list.add(treeNode.val);
            if (treeNode.left != null) queue.add(treeNode.left);
            if (treeNode.right != null) queue.add(treeNode.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
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

        int[] res = new LevelOrder().levelOrder(root1);
        System.out.println(JSON.toJSONString(res));
    }

}
