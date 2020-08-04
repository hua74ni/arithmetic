package com.arithmetic.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: Generate
 * @Description: 118. 杨辉三角
 * @Author: huangdh
 * @Date: 2020/7/20 上午10:30
 */
public class Generate {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> total = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            int num = i + 1;
            List<Integer> integers = new ArrayList<>(num);
            for (int j = 0; j < num; j++) {
                if (j == 0 || j == num - 1) {
                    integers.add(1);
                    continue;
                }
                List<Integer> preList = total.get(i - 1);
                int sum = preList.get(j - 1) + preList.get(j);
                integers.add(sum);
            }
            total.add(integers);
        }
        return total;
    }

    public static void main(String[] args) {
        int numRows = 5;
        List<List<Integer>> total = new Generate().generate(numRows);
        for (List<Integer> integers : total) {
            System.out.println(JSON.toJSONString(integers));
        }
    }
}
