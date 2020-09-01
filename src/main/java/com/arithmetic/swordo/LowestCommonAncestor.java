package com.arithmetic.swordo;

/**
 * 68 - II. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode findLeft = lowestCommonAncestor(root.left, p, q);
        TreeNode findRight = lowestCommonAncestor(root.right, p, q);
        if (findLeft == null) return findRight;
        if (findRight == null) return findLeft;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(6);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(8);
        TreeNode root4 = new TreeNode(0);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(9);
        TreeNode root8 = new TreeNode(3);
        TreeNode root9 = new TreeNode(5);

        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.left = root6;
        root3.right = root7;
        root5.left = root8;
        root5.right = root9;

        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root1, root2, root5).val);;
    }

}
