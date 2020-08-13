package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: ZlevelOrder
 * @Description: 32 - III. 从上到下打印二叉树 III
 * @Author: huangdh
 * @Date: 2020/8/13 上午10:24
 */
public class ZLevelOrder {

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

        List<List<Integer>> res = new ZLevelOrder().levelOrder(root1);

        for (List<Integer> re : res) {
            System.out.println(JSON.toJSONString(re));
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int leftToRight = 1;
        while (!deque.isEmpty()) {
            int n = deque.size();
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = deque.pop();
                if ((leftToRight & 1) == 1) list.addLast(treeNode.val);
                else list.addFirst(treeNode.val);
                if (treeNode.left != null) deque.add(treeNode.left);
                if (treeNode.right != null) deque.add(treeNode.right);
            }
            res.add(list);
            leftToRight++;
        }
        return res;
    }

}
