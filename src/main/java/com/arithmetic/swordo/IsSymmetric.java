package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: IsSymmetric
 * @Description: 28. 对称的二叉树
 * @Author: huangdh
 * @Date: 2020/8/11 下午9:01
 */
public class IsSymmetric {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return leftRightSymmetric(root.left, root.right);
    }

    private boolean leftRightSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null ^ right == null) return false;
        if (left.val == right.val && leftRightSymmetric(left.left, right.right)
                && leftRightSymmetric(left.right, right.left)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);



        System.out.println(new IsSymmetric().isSymmetric(root));
    }

}
