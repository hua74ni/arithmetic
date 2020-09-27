package com.arithmetic.leetcode;

/**
 * 518. 零钱兑换 II
 */
public class Change {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i < coin) continue;
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 99};
        System.out.println(new Change().change(100, coins));
    }

}