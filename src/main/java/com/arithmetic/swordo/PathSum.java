package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: PathSum
 * @Description: 34. 二叉树中和为某一值的路径
 * @Author: huangdh
 * @Date: 2020/8/13 上午11:23
 */
public class PathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
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
        root1.right = root3;
        root2.left = root4;
        root3.left = root5;
        root3.right = root6;

        root4.left = root7;
        root4.right = root8;
        root6.left = root9;
        root6.right = root10;

        List<List<Integer>> res = new PathSum().pathSum(root1, 22);

        for (List<Integer> re : res) {
            System.out.println(JSON.toJSONString(re));
        }
    }

    private List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recursion(new LinkedList<>() , root, sum);
        return res;
    }

    private void recursion(LinkedList<Integer> linkedList, TreeNode root, int sum) {
        if (root == null) return;
        if (sum == root.val && root.left == null && root.right == null) {
            LinkedList list = new LinkedList<>(linkedList);
            list.add(root.val);
            res.add(new LinkedList<>(list));
            return;
        }
        linkedList.add(root.val);
        sum = sum - root.val;
        recursion(linkedList, root.left, sum);
        recursion(linkedList, root.right, sum);
        linkedList.removeLast();
    }

}
