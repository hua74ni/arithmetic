package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: BiggestK
 * @Description: 寻找第K大
 * @Author: huangdh
 * @Date: 2020/9/28 下午2:04
 */
public class BiggestK {

    /**
     * 寻找第K大
     * 限定语言：Python. C++. C#. Java
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
     * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
     * 测试样例：
     * [1,3,5,2,2],5,3
     * 返回：2
     */

    private int target;

    private int quickSort(int[] nums, int target) {
        this.target = target;
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - target];
    }

    private void quickSort(int[] nums, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return;
        }
        int start = nums[startIndex];
        int index = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (nums[i] < start) {
                swap(nums, index, i);
                int length = i - index;
                System.arraycopy(nums, index++, nums, index, length);
            }
        }
        nums[index] = start;
        if (index - 1 >= target) {
            quickSort(nums, startIndex, index - 1);
        }
        quickSort(nums, index + 1, endIndex);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 3, 8, 9, 6};
        int target = 2;
        System.out.println(new BiggestK().quickSort(nums, target));
        System.out.println(JSON.toJSONString(nums));
    }
}
