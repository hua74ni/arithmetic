package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MyPow
 * @Description: 16. 数值的整数次方
 * @Author: huangdh
 * @Date: 2020/8/10 下午5:10
 */
public class MyPow {

    public double myPow(double x, int n) {
        double res = 1;
        boolean position = true;
        if (x < 0) {
            if ((n & 1) == 1) position = false;
        }
        x = Math.abs(x);
        if (x == 1) {
            if (position) return 1;
            return -1;
        }

        if (n > 0) {
            while (n > 0) {
                res = res * x;
                n--;
            }
        } else {
            if (n == Integer.MIN_VALUE || n == Integer.MAX_VALUE) return 0;
            n = Math.abs(n);
            while (n > 0) {
                res = res * x;
                n--;
            }
            res = 1 / res;
        }

        if (!position) return -1 * res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(-1, -2147483648));
    }

}
