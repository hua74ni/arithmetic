package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: Solution
 * @Description: 60. n个骰子的点数
 * @Author: huangdh
 * @Date: 2020/8/28 上午9:55
 */
public class Solution {

    public double[] twoSum(int n) {
        double[] res = new double[n * 6 + 1];
        double[] pre = new double[n * 6 + 1];
        for (int i = 0; i < 7; i++) {
            pre[i] = (double) 1 / 6;
            res[i] = (double) 1 / 6;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= i * 6; j++) {
                res[j] = 0;
                int start = 1;
                while (start <= 6 && start != j) {
                    int end = j - start;
                    if (end < i - 1 || end > (i - 1) * 6) {
                        start++;
                        continue;
                    }
                    res[j] += pre[end];
                    start++;
                }
                res[j] *= (double) 1 / 6;
            }
            double[] t = pre;
            pre = res;
            res = t;
        }

        double[] result = new double[n * 6 - n + 1];
        System.arraycopy(pre, n, result, 0, n * 6 - n + 1);
        return result;
    }

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Solution().twoSum(3)));
    }

}