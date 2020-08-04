package com.arithmetic.sort;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: MergeSort
 * @Description: 归并排序
 * @Author: huangdh
 * @Date: 2020/8/3 下午3:28
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 11, 2, -1};
        new MergeSort().mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    public void mergeSort(int[] nums) {
        if (nums == null) return;
        sort(0, nums.length - 1, nums);
    }

    private void sort(int start, int end, int[] nums) {
        if (end == start) return;
        int mid = (end + start) / 2;
        int left = start;
        int right = mid + 1;
        sort(left, mid, nums);
        sort(right, end, nums);

        int [] res = new int[end - start + 1];
        int index = 0;
        int leftEnd = mid;
        int rightEnd = end;
        while (left <= leftEnd && right <= rightEnd) {
            if (nums[left] > nums[right]) {
                res[index++] = nums[right++];
            } else {
                res[index++] = nums[left++];
            }
        }
        while (left <= leftEnd) {
            res[index++] = nums[left++];
        }
        while (right <= rightEnd) {
            res[index++] = nums[right++];
        }

        System.arraycopy(res, 0, nums, start, end - start + 1);
    }

}
