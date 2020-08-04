package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: SubsetsWithDup
 * @Description: 90. 子集 ||
 * @Author: huangdh
 * @Date: 2020/7/8 上午10:00
 */
public class SubsetsWithDup {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> total = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            backTrace(total, nums, new LinkedList(), 0, i, flag);
        }
        return total;
    }

    private void backTrace(List<List<Integer>> total, int[] nums, LinkedList list, int start, int max, boolean[] flag) {
        if (list.size() == max) {
            total.add(new LinkedList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (flag[i]) {
                continue;
            }
            if (i - 1 >= 0 && nums[i - 1] == nums[i] && !flag[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            flag[i] = true;
            backTrace(total, nums, list, i + 1, max, flag);
            list.remove(list.size() - 1);
            flag[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> total = new SubsetsWithDup().subsetsWithDup(nums);
        for (List<Integer> integers : total) {
            System.out.println(JSON.toJSONString(integers));
        }
    }

}
