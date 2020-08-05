package com.arithmetic.swordo;

import java.util.HashSet;
import java.util.Set;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: FindRepeatNumber
 * @Description: 03. 数组中重复的数字
 * @Author: huangdh
 * @Date: 2020/8/4 上午10:27
 */
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> dic = new HashSet<>(nums.length);
        for (int num : nums) {
            if (!dic.add(num)) return num;
        }
        return -1;
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(new FindRepeatNumber().findRepeatNumber(nums));
    }

}
