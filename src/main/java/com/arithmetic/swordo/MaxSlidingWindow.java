package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MaxSlidingWindow
 * @Description: 59 - I. 滑动窗口的最大值
 * @Author: huangdh
 * @Date: 2020/8/26 上午9:53
 */
public class MaxSlidingWindow {


    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int length = nums.length - k + 1;
        int[] res = new int[length];
        int max = Integer.MIN_VALUE;
        int index = 0;
        for (int j = k; j <= nums.length; j++) {
            if (j != k && nums[j - k - 1] != max) {
                if (nums[j - 1] > max) {
                    max = nums[j - 1];
                }
            } else {
                max = Integer.MIN_VALUE;
                for (int i = j - k; i < j; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                    }
                }
            }
            res[index++] = max;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(JSON.toJSONString(new MaxSlidingWindow().maxSlidingWindow(nums, 3)));
    }


}