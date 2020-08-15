package com.arithmetic.swordo;

import java.util.HashMap;

/**
 * 39. 数组中出现次数超过一半的数字
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int moreHalf = -1;
        int moreHalfNum = -1;
        for (int num : nums) {
            Integer value = map.get(num);
            if (value == null) value = new Integer(0);
            value = value + 1;
            map.put(num, value);
            if (value > moreHalfNum) {
                moreHalf = num;
                moreHalfNum = value;
            }
        }
        return moreHalf;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 6, 6, 7, 7};
        System.out.println(new MajorityElement().majorityElement(nums));
    }

}
