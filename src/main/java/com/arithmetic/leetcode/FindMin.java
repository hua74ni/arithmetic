package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: FindMin
 * @Description: 153. 寻找旋转排序数组中的最小值
 * @Author: huangdh
 * @Date: 2020/9/27 上午11:17
 */
public class FindMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (right >= left) {
            middle = (left + right) >> 1;
            /**
             * 递增说明 left 最小
             * 特殊情况: left == right
             */
            if (nums[left] <= nums[right]) {
                return nums[left];
            }
            /**
             * 说明 [left, middle] 是递增，最小值在后面部分
             */
            if (nums[left] <= nums[middle]) {
                left = middle + 1;
            } else {
                /**
                 * 说明 [left, middle] 非是递增，最小值在前部分，由于 无法判断 middle 是否是最小值，因此不减一
                 */
                right = middle;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 1};
        System.out.println(new FindMin().findMin(nums));
    }

}