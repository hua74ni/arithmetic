package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: Search
 * @Description: 33. 搜索旋转排序数组
 * @Author: huangdh
 * @Date: 2020/9/27 上午10:17
 */
public class Search {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int middle;
        while (right >= left) {
            middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[left] <= nums[right]) {
                break;
            }
            if (nums[left] <= nums[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        int lastStart = left;
        // [fromIndex, toIndex) 因此不减一
        int lastEnd = nums.length;
        int preStart = 0;
        // [fromIndex, toIndex) 因此不减一
        int preEnd = lastStart;
        int res = -1;
        if ((res = binarySearch(nums, preStart, preEnd, target)) >= 0) {
            return res;
        }
        if ((res = binarySearch(nums, lastStart, lastEnd, target)) >= 0) {
            return res;
        }
        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int middle;
        end = end - 1;
        while (end >= start) {
            middle = (start + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        System.out.println(new Search().search(nums, 0));

    }

}
