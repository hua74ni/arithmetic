package com.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangdh
 * @Description 两数之和
 **/
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] twoSum = new int[2];
        int tmp;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]) && i != map.get(nums[i])) {
                twoSum[0] = map.get(nums[i]);
                twoSum[1] = i;
                break;
            }

            tmp = target - nums[i];
            map.put(tmp, i);
        }
        return twoSum;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{0, 4, 3, 0};
        int target = 0;

        int[] twoSum = twoSum(nums, target);
        System.out.println("nums[" + twoSum[0] + "] + nums[" + twoSum[1] + "] = " + target);
    }

}
