package com.arithmetic.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: GetRow
 * @Description: 119. 杨辉三角II
 * @Author: huangdh
 * @Date: 2020/7/20 下午9:01
 */
public class GetRow {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> current = null;
        for (int i = 0; i < rowIndex + 1; i++) {
            int num = i + 1;
            current = new ArrayList<>(num);
            for (int j = 0; j < num; j++) {
                if (j == 0 || j == num - 1) {
                    current.add(1);
                    continue;
                }
                int sum = pre.get(j - 1) + pre.get(j);
                current.add(sum);
            }
            pre = current;
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(new GetRow().getRow(5));
    }


}
