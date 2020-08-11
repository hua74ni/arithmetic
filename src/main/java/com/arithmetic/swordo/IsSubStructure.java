package com.arithmetic.swordo;

/**
 * 26. 树的子结构
 */
public class IsSubStructure {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode BHead;

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        BHead = B;
        return findSameSubStructure(A, B);
    }

    private boolean findSameSubStructure(TreeNode A, TreeNode B) {
        if (B == null) return true;
        if (A == null && B != null) return false;
        if (A.val == B.val && findSameSubStructure(A.left, B.left)
                && findSameSubStructure(A.right, B.right)) {
            return true;
        } else if (B == BHead) {
            if (findSameSubStructure(A.left, B) || findSameSubStructure(A.right, B)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        TreeNode A = new TreeNode(1);
        TreeNode A2 = new TreeNode(0);
        TreeNode A3 = new TreeNode(1);
        TreeNode A4 = new TreeNode(-4);
        TreeNode A5 = new TreeNode(-3);

        A.left = A2;
        A.right = A3;
        A2.left = A4;
        A2.right = A5;

        TreeNode B = new TreeNode(1);
        TreeNode B2 = new TreeNode(-4);

        B.left = B2;

        System.out.println(new IsSubStructure().isSubStructure(A, B));
    }

}
