package com.arithmetic.leetcode;

/**
 * 322. 零钱兑换
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int i1 = 0; i1 < coins.length; i1++) {
                if (i - coins[i1] < 0) continue;
                if (i - coins[i1] != 0 && dp[i - coins[i1]] == Integer.MAX_VALUE) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[i1]] + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new CoinChange().coinChange(nums, 0));
    }

}
