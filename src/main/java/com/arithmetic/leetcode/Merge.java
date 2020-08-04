package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: Merge
 * @Description: 88. 合并两个有序数组
 * @Author: huangdh
 * @Date: 2020/7/7 上午10:36
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int mergeNum = 0;
        for (int i = 0, j = 0; i < m + mergeNum && j < n; ) {
            int num1 = nums1[i];
            int num2 = nums2[j];

            if (num1 > num2) {
                System.arraycopy(nums1, i, nums1, i + 1, m + mergeNum - i);
                nums1[i] = num2;
                i++;j++;mergeNum++;
            } else {
                i++;
            }
        }

        if (mergeNum < n) {
            System.arraycopy(nums2, n - (n - mergeNum), nums1, m + mergeNum, n - mergeNum);
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int m = 3;
        int[] nums2 = {1, 2, 3};
        int n = 3;

        new Merge().merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.println(i);
        }
    }

}
