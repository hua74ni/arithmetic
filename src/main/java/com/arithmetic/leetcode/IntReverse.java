package com.arithmetic.leetcode;

/**
 * @Author huangdh
 * @Description 7. 整数反转
 **/
public class IntReverse {

    public int reverse(int x) {

        if (x > Integer.MAX_VALUE || x == 0) {
            return 0;
        }

        StringBuilder result = new StringBuilder(String.valueOf(x));
        result = result.reverse();
        boolean negative = false;

        if (x < 0) {
            negative = true;
            result.deleteCharAt(result.length() - 1);
        }

        while (result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        if (Long.valueOf(result.toString()) > Integer.MAX_VALUE) {
            return 0;
        }

        return negative ? Integer.valueOf("-" + result.toString()) : Integer.valueOf(result.toString());
    }

    public static void main(String[] args) {

        IntReverse intReverse = new IntReverse();
        System.out.println(intReverse.reverse(-2147483648));
    }

}
