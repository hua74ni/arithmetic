package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: FindContinuousSequence
 * @Description: 57 - II. 和为s的连续正数序列
 * @Author: huangdh
 * @Date: 2020/8/25 上午9:41
 */
public class FindContinuousSequence {

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int sum = 3;
        int i = 1;
        int j = 2;
        while (i <= target / 2) {
            if (sum > target) {
                sum -= i;
                i++;
            } else if (sum < target) {
                j++;
                sum += j;
            } else {
                int[] arrays = new int[j - i + 1];
                for (int k = i, index = 0; k <= j; k++) {
                    arrays[index++] = k;
                }
                list.add(arrays);
                sum -= i;
                i++;
            }
        }
        return list.toArray(new int[0][]);
    }


    public static void main(String[] args) {
        int[][] res = new FindContinuousSequence().findContinuousSequence(9);
        for (int i = 0; i < res.length; i++) {
            System.out.println(JSON.toJSONString(res[i]));
        }
    }

}
