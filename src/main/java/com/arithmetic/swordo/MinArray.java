package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MinArray
 * @Description: 11. 旋转数组的最小数字
 * @Author: huangdh
 * @Date: 2020/8/9 上午9:18
 */
public class MinArray {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (i + 1 <= numbers.length - 1 && numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 2, 2, 0, 1};
        System.out.println(new MinArray().minArray(numbers));
    }
}
