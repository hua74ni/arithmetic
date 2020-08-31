package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MaxProfit
 * @Description: 63. 股票的最大利润
 * @Author: huangdh
 * @Date: 2020/8/31 上午9:40
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                res = Math.max(prices[i] - min, res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 6, 4, 3, 1};
        System.out.println(new MaxProfit().maxProfit(prices));
    }

}
