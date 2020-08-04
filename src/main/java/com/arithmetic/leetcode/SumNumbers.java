package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: SumNumbers
 * @Description: 129. 求根到叶子节点数字之和
 * @Author: huangdh
 * @Date: 2020/7/23 上午9:39
 */
public class SumNumbers {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private Integer total = 0;

    public int sumNumbers(TreeNode root) {
        trace(new StringBuilder(), root);
        return total;
    }

    private void trace(StringBuilder stringBuilder, TreeNode root) {
        if (root == null) return;
        if (root != null && root.left == null && root.right == null) {
            stringBuilder.append(root.val);
            total += Integer.valueOf(stringBuilder.toString());
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            return;
        }
        stringBuilder.append(root.val);
        trace(stringBuilder, root.left);
        trace(stringBuilder, root.right);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(9);
        TreeNode root3 = new TreeNode(0);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(1);

        root1.left = root2;
        root1.right = root3;

        root2.left = root4;
        root2.right = root5;

        System.out.println(new SumNumbers().sumNumbers(root1));
    }

}
