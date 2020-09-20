package com.arithmetic.leetcode;

/**
 * 55. 跳跃游戏
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return true;
        int pre = nums.length - 2;
        int distance = 1;
        while (pre > 0) {
            if (nums[pre] < distance) {
                distance++;
            } else {
                distance = 1;
            }
            pre--;
        }
        if (nums[pre] >= distance) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump().canJump(new int[]{2, 3, 1, 1, 4}));
    }

}
