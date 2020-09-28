package com.arithmetic.sort;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: NewHeapSort
 * @Description: 堆排序
 * @Author: huangdh
 * @Date: 2020/9/28 下午2:23
 */
public class NewHeapSort {

    /**
     * 该节点的左右节点
     * 左节点:(i + 1) * 2 - 1  右节点:(i + 1) * 2
     * 该节点的父节点: (i - 1) / 2
     */
    private void heapSort(int[] nums) {
        int length = nums.length;
        buildMin(nums, length);
        length--;
        for (int i = length - 1; i > 0; i--) {
            swap(nums, 0, length);
            length--;
            minHeapify(nums, length, 0);
        }
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
        int[] nums = new int[]{4, 5, 11, 2, -1};
        new NewHeapSort().heapSort(nums);
        System.out.println(JSON.toJSONString(nums));
    }

}
