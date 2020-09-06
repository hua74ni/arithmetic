package com.arithmetic.leetcode;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int star = i + 1;
            int end = nums.length - 1;
            while (end != star) {
                int t = nums[star] + nums[end] + nums[i];
                if (t > target) {
                    end--;
                } else if (t < target) {
                    star++;
                } else {
                    return t;
                }
                if (Math.abs(closestSum - target) >
                        Math.abs(t - target)) {
                    closestSum = t;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 8, 16, 32, 64, 128};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 82));
    }

}
