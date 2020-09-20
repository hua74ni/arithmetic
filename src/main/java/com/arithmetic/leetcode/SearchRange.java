package com.arithmetic.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int findTarget = -1;
        int[] res = new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while (end >= start) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                findTarget = mid;
                break;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if (findTarget != -1) {
            int left = findTarget;
            while ((left = left - 1) >= 0 && nums[left] == target) { }
            res[0] = left + 1;
            int right = findTarget;
            while ((right = right + 1) <= nums.length - 1 && nums[right] == target) { }
            res[1] = right - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6};
        int[] res = new SearchRange().searchRange(nums, 6);

        System.out.println(res[0] + " " + res[1]);
    }

}
