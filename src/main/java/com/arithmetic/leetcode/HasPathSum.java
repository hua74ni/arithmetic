package com.arithmetic.leetcode;

public class HasPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return track(root, sum);
    }

    private boolean track(TreeNode root, int target) {
        if (root == null) return false;
        if (root.val == target && root.left == null && root.right == null) {
            return true;
        }
        if (track(root.left, target - root.val)) return true;
        if (track(root.right, target - root.val)) return true;
        return false;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(4);
        TreeNode root3 = new TreeNode(8);
        TreeNode root4 = new TreeNode(11);
        TreeNode root5 = new TreeNode(13);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(2);
        TreeNode root9 = new TreeNode(5);
        TreeNode root10 = new TreeNode(1);

        root1.left = root2;
//        root1.right = root3;
//
//        root2.left = root4;
//        root3.left = root5;
//        root3.right = root6;
//
//        root4.left = root7;
//        root4.right = root8;
//        root6.left = root9;
//        root6.right = root10;

        System.out.println(new HasPathSum().hasPathSum(root1, 5));
    }

}
