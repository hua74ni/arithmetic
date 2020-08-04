package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: AddBinary
 * @Description: 二进制求和
 * @Author: huangdh
 * @Date: 2020/6/30 上午9:48
 */
public class AddBinary {

    public String addBinary(String a, String b) {

        if (a == null || "".equals(a)) {
            return b;
        }
        if (b == null || "".equals(b)) {
            return a;
        }

        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        int aLength = a.length() - 1;
        int bLength = b.length() - 1;

        StringBuilder stringBuilder = new StringBuilder();
        boolean isPlusOne = false;
        for (; aLength >= 0 || bLength >= 0; aLength--, bLength--) {
            char left = '0';
            char right = '0';
            if (aLength >= 0) {
                left = aChars[aLength];
            }
            if (bLength >= 0) {
                right = bChars[bLength];
            }

            char result;
            boolean addOne = false;

            if (left == '1') {
                if (right == '1') {
                    result = '0';
                    addOne = true;
                } else {
                    result = '1';
                }
            } else {
                if (right == '1') {
                    result = '1';
                } else {
                    result = '0';
                }
            }
            if (result == '1') {
                if (isPlusOne) {
                    result = isPlusOne ? '0' : '1';
                    addOne = true;
                }
            } else {
                result = isPlusOne ? '1' : '0';
            }
            isPlusOne = addOne;
            stringBuilder.insert(0, result);
        }

        if (isPlusOne) {
            stringBuilder.insert(0, '1');
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";
        System.out.println(new AddBinary().addBinary(a, b));
    }

}
