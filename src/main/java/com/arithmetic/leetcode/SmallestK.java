package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: SmallestK
 * @Description: 面试题 17.14. 最小K个数
 * @Author: huangdh
 * @Date: 2020/9/28 下午1:51
 */
public class SmallestK {

    public int[] smallestK(int[] arr, int k) {
        int length = arr.length;
        buildMin(arr, length);
        length--;
        for (int i = k; i > 0; i--) {
            swap(arr, 0, length);
            length--;
            minHeapify(arr, length, 0);
        }
        int[] res = new int[k];
        length = arr.length - 1;
        for (int i = 0; i < k; i++) {
            res[i] = arr[length--];
        }
        return res;
    }

    private void buildMin(int[] nums, int length) {
        for (int i = (int) Math.floor(nums.length / 2); i >= 0; i--) {
            minHeapify(nums, length, i);
        }
    }

    private void minHeapify(int[] nums, int length, int i) {
        int left = (i + 1) * 2 - 1;
        int right = (i + 1) * 2;

        int smallestIndex = i;
        if (left < length && nums[smallestIndex] > nums[left]) {
            smallestIndex = left;
        }
        if (right < length && nums[smallestIndex] > nums[right]) {
            smallestIndex = right;
        }
        if (i != smallestIndex) {
            swap(nums, smallestIndex, i);
            minHeapify(nums, length, smallestIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 7, 2, 4, 6, 8};
        System.out.println(JSON.toJSONString(new SmallestK().smallestK(nums, 4)));
    }

}
