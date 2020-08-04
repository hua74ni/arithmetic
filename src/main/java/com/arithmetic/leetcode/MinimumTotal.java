package com.arithmetic.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: MinimumTotal
 * @Description: 120. 三角形最小路径和
 * @Author: huangdh
 * @Date: 2020/7/20 下午9:13
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size() + 1;
        for (int i = n - 3; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                List<Integer> current = triangle.get(i);
                List<Integer> next = triangle.get(i + 1);
                current.set(j, Math.min(next.get(j), next.get(j + 1)) + current.get(j));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Lists.newArrayList(2));
        triangle.add(Lists.newArrayList(3, 4));
        triangle.add(Lists.newArrayList(6, 5, 7));
        triangle.add(Lists.newArrayList(4, 1, 8, 3));
        triangle.forEach(System.out::println);

        System.out.println(new MinimumTotal().minimumTotal(triangle));
    }

}
