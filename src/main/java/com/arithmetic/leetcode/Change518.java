package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: Change518
 * @Description: 518. 零钱兑换 II
 * @Author: huangdh
 * @Date: 2020/10/24 下午3:07
 */
public class Change518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin > i) continue;
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Change518().change(5, new int[]{1, 2, 5}));
    }

}
