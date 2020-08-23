package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: SingleNumbers
 * @Description: 56 - I. 数组中数字出现的次数
 * @Author: huangdh
 * @Date: 2020/8/23 上午11:00
 */
public class SingleNumbers {

    public int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }

        int mask = 1;
        while ((k & mask) == 0) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 4, 6};
        System.out.println(JSON.toJSONString(new SingleNumbers().singleNumbers(nums)));
    }

}
