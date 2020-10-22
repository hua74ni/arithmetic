package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: Search704
 * @Description: 704. 二分查找
 * @Author: huangdh
 * @Date: 2020/10/22 下午4:50
 */
public class Search704 {

    public int search(int[] nums, int target) {
        int result = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == target) {
                result = mid;
                break;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Search704().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

}
