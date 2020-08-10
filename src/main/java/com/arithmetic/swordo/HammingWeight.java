package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: HammingWeight
 * @Description: 15. 二进制中1的个数
 * @Author: huangdh
 * @Date: 2020/8/10 下午4:42
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) res++;
            n = n >>> 1;
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new HammingWeight().hammingWeight(Integer.MAX_VALUE + 1));

    }

}
