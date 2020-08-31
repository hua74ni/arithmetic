package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: LastRemaining
 * @Description: 62. 圆圈中最后剩下的数字
 * @Author: huangdh
 * @Date: 2020/8/30 下午5:17
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LastRemaining().lastRemaining(5, 3));
    }

}
