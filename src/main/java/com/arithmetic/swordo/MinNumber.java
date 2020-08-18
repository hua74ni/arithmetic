package com.arithmetic.swordo;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MinNumber
 * @Description: 45. 把数组排成最小的数
 * @Author: huangdh
 * @Date: 2020/8/17 下午2:11
 */
public class MinNumber {

    public String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
        System.out.println(new MinNumber().minNumber(nums));

    }

}
