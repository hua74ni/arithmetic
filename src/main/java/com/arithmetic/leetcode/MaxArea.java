package com.arithmetic.leetcode;

/**
 * @Author huangdh
 * @Description 11. 盛最多水的容器
 **/
public class MaxArea {


    public int maxArea(int[] height) {

        /**
         * 暴力破解

        int maxArea = 0;
        int tmp;

        for (int i = 0; i < height.length; i++) {
            for (int j = 1; j < height.length; j++) {

                if (j <= i) {
                    continue;
                }
                tmp = (j - i) * Math.min(height[i], height[j]);
                if (tmp > maxArea) {
                    maxArea = tmp;
                }
            }
        }
        return maxArea;**/

        int maxArea = 0;
        int tmp;

        int i = 0;
        int j = height.length - 1;


        while (j > i) {
            tmp = (j - i) * Math.min(height[i], height[j]);
            if (tmp > maxArea) {
                maxArea = tmp;
            }
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        MaxArea maxArea = new MaxArea();

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea.maxArea(height));
    }

}
