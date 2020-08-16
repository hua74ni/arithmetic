package com.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {

    private Map<Integer, Integer> map = new HashMap<>();
    private int [] po;

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        po = preorder;
        TreeNode root = recur(0, 0, inorder.length - 1);
        return root;
    }

    private TreeNode recur(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        TreeNode root = new TreeNode(po[preRoot]);
        int i = map.get(po[preRoot]);
        root.left = recur(preRoot + 1, inLeft, i - 1);
        root.right = recur(preRoot + (i - 1 - inLeft + 1) + 1, i + 1, inRight);
        return root;
    }

    public static void main(String[] args) {

        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = new BuildTree().buildTree(preorder, inorder);

    }

}
