package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

/**
 * 21. 调整数组顺序使奇数位于偶数前面
 */
public class Exchange {

    public int[] exchange(int[] nums) {
        int mid = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                if (i != mid) {
                    swap(mid, i, nums);
                }
                mid++;
            }
        }
        return nums;
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4};

        int[] res = new Exchange().exchange(nums);

        System.out.println(JSON.toJSONString(res));
    }

}
