package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: NumWays
 * @Description: 10- II. 青蛙跳台阶问题
 * @Author: huangdh
 * @Date: 2020/8/6 下午4:45
 */
public class NumWays {

    public static void main(String[] args) {

        System.out.println(new NumWays().numWays(7));
    }

    public int numWays(int n) {
        if (n <= 1) return 1;
        int[] ints = new int[n + 1];
        ints[0] = 1;
        ints[1] = 1;

        for (int i = 2; i <= n; i++) {
            ints[i] = (ints[i - 1] + ints[i - 2]) % 1000000007;
        }
        return ints[n];
    }
}
