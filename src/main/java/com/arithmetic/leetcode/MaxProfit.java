package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: MaxProfit
 * @Description: 121. 买卖股票的最佳时机
 * @Author: huangdh
 * @Date: 2020/6/28 下午8:46
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }
        int maxProfit = 0;

        // 算出 前后差距的差异，正数差异说明是 递增
        int[] diffs = new int[prices.length];
        diffs[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            diffs[i] = prices[i] - prices[i - 1];
        }

        for (int i = 0; i < prices.length; i++) {
            if (diffs[i] > 0) {
                maxProfit += diffs[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(new MaxProfit().maxProfit(prices));
    }



}
