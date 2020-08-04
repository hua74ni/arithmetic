package com.arithmetic.sort;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: SelectSort
 * @Description: 选择排序
 * @Author: huangdh
 * @Date: 2020/8/3 上午10:56
 */
public class SelectSort {

    private void SelectSort(int[] nums) {

        int index = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++, index++) {
            int minIndex = index;
            for (int j = index; j < length; j++) {
                if (nums[minIndex] > nums[j]) minIndex = j;
            }
            if (minIndex == index) continue;
            swap(index, minIndex, nums);

        }
    }

    private void swap(int i, int j, int[] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 11, 2, -1};
        new SelectSort().SelectSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
