package com.arithmetic.sort;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: QuickSort
 * @Description: 快速排序
 * @Author: huangdh
 * @Date: 2020/8/3 下午2:36
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 11, 2, -1};
        new QuickSort().quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    private void quickSort(int[] nums) {
        if (nums == null) return;
        sort(0, nums.length - 1, nums);
    }

    private void sort(int start, int end, int[] nums) {
        if (end <= start) return;
        int midIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[midIndex] > nums[i]) {
                int move = nums[i];
                System.arraycopy(nums, midIndex, nums, midIndex + 1, i - midIndex);
                nums[midIndex] = move;
                midIndex++;
            }
        }
        sort(start, midIndex - 1, nums);
        sort(midIndex + 1, end, nums);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
