package com.arithmetic.leetcode;

import java.util.Arrays;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: Search
 * @Description: 81. 搜索旋转排序数组 II
 * @Author: huangdh
 * @Date: 2020/9/27 上午10:17
 */
public class SearchII {

    public boolean search(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (right >= left) {
            middle = (left + right) >> 1;
            if (nums[middle] == target) {
                return true;
            }
            if (target <= nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return false;
    }

//    public boolean search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        int middle;
//        while (right >= left) {
//            middle = (left + right) >> 1;
//            if (nums[middle] == target) {
//                return true;
//            }
//            if (nums[left] <= nums[middle]) {
//                if (nums[left] <= target && target <= nums[middle]) {
//                    right = middle - 1;
//                } else {
//                    left = middle + 1;
//                }
//            } else {
//                if (nums[middle] <= target && target <= nums[right]) {
//                    left = middle + 1;
//                } else {
//                    right = middle - 1;
//                }
//            }
//        }
//        return false;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 2};
        System.out.println(new SearchII().search(nums, 3));
    }

}
