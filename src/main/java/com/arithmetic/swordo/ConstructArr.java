package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: ConstructArr
 * @Description: 66. 构建乘积数组
 * @Author: huangdh
 * @Date: 2020/9/1 上午9:52
 */
public class ConstructArr {

    public int[] constructArr(int[] a) {
        if (a.length == 1 || a.length == 0) return new int[a.length];
        int[] res = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            if (i == a.length - 1) res[i] = a[i];
            else res[i] = a[i] * res[i + 1];
        }
        res[0] = res[1];
        for (int i = 1; i < res.length; i++) {
            if (i == res.length - 1) {
                res[i] = a[i - 1];
            } else {
                res[i] = a[i - 1] * res[i + 1];
                a[i] = a[i] * a[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5};
        System.out.println(JSON.toJSONString(new ConstructArr().constructArr(a)));
    }

}
