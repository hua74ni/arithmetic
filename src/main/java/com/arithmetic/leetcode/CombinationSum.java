package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 */
public class CombinationSum {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        backTrace(0, new ArrayList<>(), target);
        return res;
    }

    private void backTrace(int begin, List<Integer> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        for (int i = begin; i < this.candidates.length; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            list.add(candidates[i]);
//            System.out.println("递归之前 => " + JSON.toJSONString(list) + "，剩余 = " + (target - candidates[i]));
            backTrace(i, list, target - candidates[i]);
            list.remove(list.size() - 1);
//            System.out.println("递归之后 => " + JSON.toJSONString(list));
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        List<List<Integer>> lists = new CombinationSum().combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
