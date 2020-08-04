package com.arithmetic.sort;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: BubbleSort
 * @Description: 冒泡排序
 * @Author: huangdh
 * @Date: 2020/8/3 上午11:39
 */
public class BubbleSort {


    public void bubbleSort(int [] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j - 1] > nums[j]) swap(j - 1, j, nums);
            }
        }
    }

    private void swap(int i, int j, int [] nums) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{4, 5, 11, 2, -1};
        int[] nums = new int[]{5, 4, 3, 2, 1};
        new BubbleSort().bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

}
