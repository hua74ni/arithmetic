package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: Search
 * @Description: 53 - I. 在排序数组中查找数字 I
 * @Author: huangdh
 * @Date: 2020/8/22 上午9:58
 */
public class Search {

    public int search(int[] nums, int target) {
        int res = 0;

        int start = 0;
        int end = nums.length - 1;
        int index = 0;
        while (end >= start) {
            index = (end + start) / 2;
            if (nums[index] == target) {
                res++;
                break;
            }
            if (nums[index] > target) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }

        // iterator right
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > target) break;
            if (nums[index] == target) res++;
        }
        // iterator left
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] < target) break;
            if (nums[index] == target) res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(new Search().search(nums, 1));

    }

}
