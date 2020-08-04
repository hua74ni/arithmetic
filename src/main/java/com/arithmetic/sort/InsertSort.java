package com.arithmetic.sort;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: InsertSort
 * @Description: 插入排序
 * @Author: huangdh
 * @Date: 2020/8/3 上午11:10
 */
public class InsertSort {

    public void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            int start = 0, end = i, index = i;
            while (end >= start) {
                index = (start + end) / 2;
                if (nums[i] > nums[index]) {
                    start = index + 1;
                } else {
                    end = index - 1;
                }
            }
            if (index == i) continue;
            System.arraycopy(nums, index, nums, index + 1, i - index);
            nums[index] = current;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 11, 2, -1};
        new InsertSort().insertSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
