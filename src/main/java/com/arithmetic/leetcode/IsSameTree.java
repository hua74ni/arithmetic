package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: IsSameTree
 * @Description: 100. 相同的树
 * @Author: huangdh
 * @Date: 2020/7/14 下午9:16
 */
public class IsSameTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null ^ right == null) {
            return false;
        }
        return left.val == right.val && isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
    }

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        p1.left = p2;
        p1.right = p3;

        System.out.println(new IsSameTree().isSameTree(p1, p1));
    }

}
