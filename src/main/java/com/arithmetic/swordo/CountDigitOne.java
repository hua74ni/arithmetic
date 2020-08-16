package com.arithmetic.swordo;

/**
 * todo
 * 43. 1～n整数中1出现的次数
 */
public class CountDigitOne {

    public int countDigitOne(int n) {
        if (n < 1) return 0;
        if (n <= 9) return 1;
        int res;
        int max = 9;
        int preMax = 9;
        int digit = 0;
        while (max < n) {
            preMax = max;
            digit++;
            max = max * 10 + 9;
        }

        int[] couts = new int[digit];
        couts[0] = 1;
        for (int i = 1; i < digit; i++) {
            couts[i] = (int) (Math.pow(10, i) + 10 * couts[i - 1]);
        }
        res = couts[digit - 1];

        for (int i = preMax; i <= n; i++) {
            int index = i;
            while (index > 0) {
                if (index % 10 == 1) res++;
                index = index / 10;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new CountDigitOne().countDigitOne(824883294));
    }

}
