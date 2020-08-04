package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: MaxDepth
 * @Description: 104. 二叉树的最大深度
 * @Author: huangdh
 * @Date: 2020/7/15 下午9:54
 */
public class MaxDepth {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Integer result;
        result = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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

        System.out.println(new MaxDepth().maxDepth(root1));
    }

}
