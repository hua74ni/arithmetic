package com.arithmetic.leetcode;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        int result = nums.length;
        if (result <= 2) {
            return result;
        }

        int pre = nums[0];
        int current;
        for (int i = 1; i < result; i++) {
            current = nums[i];
            if (pre == current) {
                int duplicates = 0;
                for (int next = i + 1; next < result; next++) {
                    if (nums[next] != pre) {
                        break;
                    }
                    ++duplicates;
                }
                if (duplicates > 0) {
                    System.arraycopy(nums, i + duplicates + 1, nums, i + 1, nums.length - duplicates - i - 1);
                    result -= duplicates;
                }
            }
            pre = current;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
    }

}
