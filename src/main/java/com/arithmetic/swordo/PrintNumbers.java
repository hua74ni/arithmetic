package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: PrintNumbers
 * @Description: 17. 打印从1到最大的n位数
 * @Author: huangdh
 * @Date: 2020/8/10 下午5:47
 */
public class PrintNumbers {

    public int[] printNumbers(int n) {
        int max = 0;
        while (n > 0) {
            max = max * 10;
            max = max + 9;
            n--;
        }
        int[] res = new int[max];
        for (int i = 1; i <= max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new PrintNumbers().printNumbers(1);
        for (int re : res) {
            System.out.print(re + ", ");
        }
    }

}
