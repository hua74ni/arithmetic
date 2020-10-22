package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: Permute
 * @Description: 46. 全排列
 * @Author: huangdh
 * @Date: 2020/10/22 下午3:52
 */
public class Permute {

    private int[] nums;
    private List<List<Integer>> total = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return total;
        this.nums = nums;
        backtrack(new ArrayList<>());
        return total;
    }

    private void backtrack(List<Integer> integers) {
        if (integers.size() == nums.length) {
            total.add(new ArrayList<>(integers));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (integers.contains(nums[i])) continue;
            integers.add(nums[i]);
            backtrack(integers);
            integers.remove(integers.size() - 1);
        }
    }

}
