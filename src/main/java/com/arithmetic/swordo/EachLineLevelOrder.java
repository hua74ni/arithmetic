package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: EachLineLevelOrder
 * @Description: 32 - II. 从上到下打印二叉树 II
 * @Author: huangdh
 * @Date: 2020/8/13 上午10:06
 */
public class EachLineLevelOrder {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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

        List<List<Integer>> res = new EachLineLevelOrder().levelOrder(root1);

        for (List<Integer> re : res) {
            System.out.println(JSON.toJSONString(re));
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = n; i > 0; i--) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            res.add(list);
        }
        return res;
    }

}
