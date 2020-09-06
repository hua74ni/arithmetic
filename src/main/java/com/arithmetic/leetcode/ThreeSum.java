package com.arithmetic.leetcode;

import java.util.*;

/**
 * @Author huangdh
 * @Description 15. 三数之和
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            while (l < r) {
                int t = nums[l] + nums[r] + nums[i];
                if (t == 0) {
                    listList.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                }
                if (0 <= t) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return listList;
    }


    public static void main(String[] args) {

        ThreeSum threeSum = new ThreeSum();

        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        List<List<Integer>> listList = threeSum.threeSum(nums);

        for (List<Integer> list : listList) {

            for (Integer i : list) {
                System.out.print(" " + i + " ");
            }
            System.out.println();
        }
    }

}
