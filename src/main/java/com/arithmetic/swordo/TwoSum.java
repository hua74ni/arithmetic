package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: TwoSum
 * @Description: 57. 和为s的两个数字
 * @Author: huangdh
 * @Date: 2020/8/24 上午10:25
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int end = nums.length - 1;
        int start = 0;
        while (end > start) {
            int s = nums[start] + nums[end];
            if (s == target) break;
            if (s > target) end--;
            if (s < target) start++;
        }
        return new int[]{nums[start], nums[end]};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 26, 30, 31, 47, 60};
        System.out.println(JSON.toJSONString(new TwoSum().twoSum(nums, 40)));
    }

}
