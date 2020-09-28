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
                 * 说明 [middle, right] 是递增，最小值在前面部分,注意 此时的 middle可能是最小值
                 */
                right = middle;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 1, 2, 3};
        System.out.println(new FindMin().findMin(nums));
    }

}