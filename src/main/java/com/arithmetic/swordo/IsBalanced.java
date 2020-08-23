package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: IsBalanced
 * @Description: 55 - II. 平衡二叉树
 * @Author: huangdh
 * @Date: 2020/8/23 上午10:28
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
        if (root == null) return true;
        if (!isBalanced(root.left) || !isBalanced(root.right)
                || Math.abs(maxDepth(root.left) - maxDepth((root.right))) > 1)
            return false;
        return true;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(3);
        TreeNode root5 = new TreeNode(3);
        TreeNode root6 = new TreeNode(4);
        TreeNode root7 = new TreeNode(4);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root4.left = root6;
        root4.right = root7;

        System.out.println(new IsBalanced().isBalanced(root1));

    }

}
