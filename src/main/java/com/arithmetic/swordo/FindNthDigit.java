package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: FindNthDigit
 * @Description: 44. 数字序列中某一位的数字
 * @Author: huangdh
 * @Date: 2020/8/17 上午10:22
 */
public class FindNthDigit {

    public int findNthDigit(int n) {
        int res = 0;
        int digit = 1;
        int count = 9;
        while (count < n) {
            n = n - count;
            digit++;
            count = (int) (9 * digit * Math.pow(10, digit - 1));
        }

        int start = (int) Math.pow(10, digit - 1);
        long num = start + (n - 1) / digit;
        int index = (n - 1) % digit;
        for (int i = index; i < digit; i++) {
            res = (int) (num % 10);
            num = num / 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new FindNthDigit().findNthDigit(15));
    }

}
