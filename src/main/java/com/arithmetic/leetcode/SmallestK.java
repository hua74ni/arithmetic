package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: SmallestK
 * @Description: 面试题 17.14. 最小K个数
 * @Author: huangdh
 * @Date: 2020/9/28 下午1:51
 */
public class SmallestK {

    // TODO: 2020/9/28 堆排序优化
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        System.out.println(JSON.toJSONString(new SmallestK().smallestK(nums, 4)));
    }

}
