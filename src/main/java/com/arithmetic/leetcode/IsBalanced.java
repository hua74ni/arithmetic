package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: IsBalanced
 * @Description: 110. 平衡二叉树
 * @Author: huangdh
 * @Date: 2020/7/17 上午10:08
 */
public class IsBalanced {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = isBalanced(root.left) && isBalanced(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1;
        return flag;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode21 = new TreeNode(2);

        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode31 = new TreeNode(3);
        TreeNode treeNode32 = new TreeNode(3);
        TreeNode treeNode33 = new TreeNode(3);

        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode41 = new TreeNode(4);
        TreeNode treeNode42 = new TreeNode(4);
        TreeNode treeNode43 = new TreeNode(4);
        TreeNode treeNode44 = new TreeNode(4);
        TreeNode treeNode45 = new TreeNode(4);

        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode51 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode21;

        treeNode2.left = treeNode3;
        treeNode2.right = treeNode31;
        treeNode21.left = treeNode32;
        treeNode21.right = treeNode33;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode41;
//        treeNode31.left = treeNode42;
//        treeNode31.right = treeNode43;
//        treeNode32.left = treeNode44;
//        treeNode32.right = treeNode45;
//        treeNode33.left = null;
//        treeNode33.right = null;
//
        treeNode4.left = treeNode5;
        treeNode4.right = treeNode51;

        System.out.println(new IsBalanced().isBalanced(treeNode1));
    }

}
