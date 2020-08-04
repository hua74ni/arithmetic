package com.arithmetic.sort;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: HeapSort
 * @Description: 堆排序
 * @Author: huangdh
 * @Date: 2020/8/3 下午3:52
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 11, 2, -1};
        new HeapSort().heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public void heapSort(int[] nums) {
        int length = nums.length;
        buildMaxHeap(nums, length);

        for (int i = length - 1; i >= 0; i--) {
            swap(nums, i, 0);
            length--;
            maxHeapify(nums, length, 0);
        }
    }

    private void buildMaxHeap(int[] nums, int length) {
        for (int i = (int) Math.floor(length / 2); i >= 0; i--) {
            maxHeapify(nums, length, i);
        }
    }

    private void maxHeapify(int[] nums, int length, int i) {

        int left = (i + 1) * 2 - 1;
        int right = (i + 1) * 2;

        int largestIndex = i;
        if (left < length && nums[largestIndex] < nums[left]) {
            largestIndex = left;
        }
        if (right < length && nums[largestIndex] < nums[right]) {
            largestIndex = right;
        }
        if (largestIndex != i) {
            swap(nums, i, largestIndex);
            maxHeapify(nums, length, largestIndex);
        }
    }

    private void swap(int [] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
