package com.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: SingleNumber
 * @Description: 136. 只出现一次的数字
 * @Author: huangdh
 * @Date: 2020/7/27 上午10:56
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {3, 4, 4, 4};
        System.out.println(new SingleNumber().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {

        HashMap<Integer, Integer> hashMap = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            Integer integer = hashMap.get(nums[i]);
            if (integer == null) integer = new Integer(0);
            integer++;
            hashMap.put(nums[i], integer);
        }
        return hashMap.entrySet().stream().filter(integerIntegerEntry -> integerIntegerEntry.getValue() == 1).
                findFirst().map(Map.Entry::getKey).orElse(-1);
    }
}
