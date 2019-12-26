package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangdh
 * leetCode 6. Z 字形变换
 **/
public class ZConvert {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        //init
        List<StringBuilder> stringBuilders = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            stringBuilders.add(new StringBuilder());
        }

        //一个周期
        int length = numRows + numRows - 2;
        int start = numRows - 2;
        int t = start;

        for (int i = 0; i < s.length(); i++) {

            int temp = i % length;
            // reset
            if (temp == 0) t = start;
            StringBuilder sb;
            if (temp < numRows) {
                sb = stringBuilders.get(temp);
            } else {
                sb = stringBuilders.get(t--);
            }
            sb.append(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            result.append(stringBuilder.toString());
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String str = "LEETCODEISHIRING";

        ZConvert zConvert = new ZConvert();
        System.out.println(zConvert.convert(str, 4));

        // O(n,m) = 2n + m = m

    }

}
