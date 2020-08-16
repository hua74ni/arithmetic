package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 40. 最小的k个数
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] arrays = new int[k];
        System.arraycopy(arr, 0, arrays, 0, k);

        return arrays;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{0,1,2,1};
        System.out.println(JSON.toJSONString(new GetLeastNumbers().getLeastNumbers(arr, 1)));
    }

}
