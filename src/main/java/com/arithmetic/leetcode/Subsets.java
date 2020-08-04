package com.arithmetic.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: Subsets
 * @Description: 78. 子集
 * @Author: huangdh
 * @Date: 2020/7/3 下午2:14
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> total = new LinkedList<>();
        for (int i = 0; i < nums.length + 1; i++) {
            backTrace(total, i, 0, nums, new LinkedList<>());
        }
        return total;
    }

    private void backTrace(List<List<Integer>> total, int max, int start, int[] nums, List<Integer> integers) {
        if (integers.size() == max) {
            total.add(new LinkedList<>(integers));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            integers.add(nums[i]);
            backTrace(total, max, i + 1, nums, integers);
            integers.remove(integers.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        System.out.println(new Subsets().subsets(nums));
    }

}
