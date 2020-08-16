package com.arithmetic.leetcode;

public class Test {

    public int divide(int dividend, int divisor) {

        int result = 0;
        boolean negative = (dividend > 0) ^ (divisor > 0);
        int t = 0;
        if (dividend == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
            t = 1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        if (divisor == 1) {
            if (negative) {
                return -(dividend + t);
            }
            if (dividend + t == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            return dividend + t;
        }

        while (dividend >= divisor) {
            dividend = dividend - divisor;
            result++;
        }
        if (dividend + t >= divisor) {
            result++;
        }

        if (result == Integer.MIN_VALUE) {
            return result + t;
        }
        if (negative) {
            return -(result + t);
        }
        return result + t;
    }

    public static void main(String[] args) {
        System.out.println(new Test().divide(-2147483648, 2));
    }

}
