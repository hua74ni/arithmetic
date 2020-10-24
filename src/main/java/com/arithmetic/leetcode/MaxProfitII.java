package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: maxProfitII
 * @Description: 122. 买卖股票的最佳时机 II
 * @Author: huangdh
 * @Date: 2020/10/24 下午4:55
 */
public class MaxProfitII {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                continue;
            }
            while (i + 1 < prices.length && prices[i + 1] > prices[i]) {
                i++;
            }
            res += prices[i] - min;
            min = prices[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(new MaxProfitII().maxProfit(prices));
    }

}
