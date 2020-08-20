package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: NthUglyNumber
 * @Description: 49. 丑数
 * @Author: huangdh
 * @Date: 2020/8/19 上午11:19
 */
public class NthUglyNumber {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        for (int j = 1; j < n; j++) {
            dp[j] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[j] == dp[p2] * 2) {
                p2++;
            }
            if (dp[j] == dp[p3] * 3) {
                p3++;
            }
            if (dp[j] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new NthUglyNumber().nthUglyNumber(10));
    }

}
