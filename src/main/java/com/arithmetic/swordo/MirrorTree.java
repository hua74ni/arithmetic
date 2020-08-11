package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MirrorTree
 * @Description: 27. 二叉树的镜像
 * @Author: huangdh
 * @Date: 2020/8/11 下午8:38
 */
public class MirrorTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        leftSwapRight(root);
        return root;
    }

    private void leftSwapRight(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        leftSwapRight(root.left);
        leftSwapRight(root.right);
    }


    public static void main(String[] args) {


    }

}
