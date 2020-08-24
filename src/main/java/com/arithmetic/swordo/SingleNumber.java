package com.arithmetic.swordo;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: SingleNumber
 * @Description: 56 - II. 数组中数字出现的次数 II
 * @Author: huangdh
 * @Date: 2020/8/24 上午9:50
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Boolean flag = map.get(nums[i]);
            if (flag == null) {
                flag = true;
            } else {
                flag = false;
            }
            map.put(nums[i], flag);
        }
        for (Map.Entry<Integer, Boolean> integerIntegerEntry : map.entrySet()) {
            if (integerIntegerEntry.getValue())
                return integerIntegerEntry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 3, 3};
        System.out.println(new SingleNumber().singleNumber(nums));

    }

}
