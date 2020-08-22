package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MissingNumber
 * @Description: 53 - II. 0～n-1中缺失的数字
 * @Author: huangdh
 * @Date: 2020/8/22 上午10:11
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        // head or tail missing number
        if (nums[0] != 0) return 0;
        if (nums[nums.length - 1] != nums.length) return nums.length;

        // center missing number
        int start = 0;
        int end = nums.length - 1;
        while (end >= start) {
            if (end - start <= 2) break;
            int index = (end + start) / 2;
            if (nums[end] - nums[index] == end - index) {
                end = index;
            } else {
                start = index;
            }
        }
        for (int i = start; i <= end; i++) {
            if (i + 1 < nums.length && nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(new MissingNumber().missingNumber(nums));
    }


}
