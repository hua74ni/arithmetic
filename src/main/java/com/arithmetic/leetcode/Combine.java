package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: Combine
 * @Description: 77. 组合
 * @Author: huangdh
 * @Date: 2020/7/1 下午9:46
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();

        int [] nums = new int [n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        backTrace(0, nums, k, result, new LinkedList<>());
        return result;
    }

    private void backTrace(int index, int[] nums, int k, List<List<Integer>> result, LinkedList<Integer> integers) {
        if (integers.size() == k) {
            result.add(new ArrayList<>(integers));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            integers.add(nums[i]);
            backTrace(i + 1, nums, k, result, integers);
            integers.remove(integers.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> listList = new Combine().combine(n, k);
        for (List<Integer> integers : listList) {
            System.out.println(JSON.toJSONString(integers));
        }

    }
}
