package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: Fib
 * @Description: 10- I. 斐波那契数列
 * @Author: huangdh
 * @Date: 2020/8/6 上午10:41
 */
public class Fib {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int [] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            ints[i] = (ints[i - 1] + ints[i - 2]) % 1000000007;
        }
        return ints[n];
    }

    public static void main(String[] args) {
        System.out.println(new Fib().fib(45));
    }

}
