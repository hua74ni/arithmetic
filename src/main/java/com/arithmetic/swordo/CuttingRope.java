package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: CuttingRope
 * @Description: 14- I. 剪绳子
 * @Author: huangdh
 * @Date: 2020/8/10 下午4:04
 */
public class CuttingRope {

    public int cuttingRope(int n) {
        if (n == 2) return 1;
        int minNum = 0;
        int maxNum = 0;
        int minlength = (int) Math.sqrt(n);
        int maxLength = minlength + 1;
        double doubleLength = Math.sqrt(n);

        while (doubleLength > minlength) {
            n = n - maxLength;
            maxNum++;
            doubleLength = Math.sqrt(n);
        }
        minNum = n / minlength;
        return (int) (Math.pow(maxLength, maxNum) * Math.pow(minlength, minNum));
    }

    public static void main(String[] args) {
        int n = 10;
        int minNum = 0;
        int maxNum = 0;
        int minlength = (int) Math.sqrt(n);
        int maxLength = minlength + 1;
        double doubleLength = Math.sqrt(n);

        while (doubleLength > minlength) {
            n = n - maxLength;
            maxNum++;
            doubleLength = Math.sqrt(n);
        }

        minNum = n / minlength;

        minNum = (int) (Math.pow(maxLength, maxNum) * Math.pow(minlength, minNum));

        System.out.println(minNum);

    }

}
