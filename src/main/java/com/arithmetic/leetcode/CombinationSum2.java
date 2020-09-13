package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 */
public class CombinationSum2 {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private boolean[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        used = new boolean[candidates.length];
        backTrace(0, new ArrayList<>(), target);
        return res;
    }

    private void backTrace(int begin, List<Integer> list, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if (target - this.candidates[i] < 0) break;
            if (i - 1 >= 0 && candidates[i - 1] == candidates[i] && !used[i - 1]) continue;
            list.add(candidates[i]);
            used[i] = true;
            backTrace(i + 1, list, target - candidates[i]);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> lists = new CombinationSum2().combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

}
