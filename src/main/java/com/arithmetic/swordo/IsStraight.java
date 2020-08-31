package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: IsStraight
 * @Description: 61. 扑克牌中的顺子
 * @Author: huangdh
 * @Date: 2020/8/30 下午4:51
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        int[] arr = new int[14];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 0无需统计
            if (nums[i] == 0) continue;
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            if (arr[nums[i]] > 0) return false;
            ++arr[nums[i]];
        }
        // 最大最小值差值小于等于4,即为顺子
        if (max - min <= 4) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 0, 1};
        System.out.println(new IsStraight().isStraight(nums));

    }

}
