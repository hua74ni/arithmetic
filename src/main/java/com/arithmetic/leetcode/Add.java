package com.arithmetic.leetcode;

/**
 * 65. 不用加减乘除做加法
 */
public class Add {

    public int add(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            int cur = a ^ b;
            b = carry;
            a = cur;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Add().add(-10, -11));
    }

}
