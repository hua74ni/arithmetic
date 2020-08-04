package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: NumTrees
 * @Description: 96. 不同的二叉搜索树
 * @Author: huangdh
 * @Date: 2020/7/14 下午8:27
 */
public class NumTrees {

    /**
     * G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)
     * f(i) = G(i-1)*G(n-i)
     * G(n) = G(0)*G(n-1) + G(1)*G(n-2) + G(2)*G(n-3) + G(3)*G(n-4) + G(4)*G(n-5) + ... + G(n-1)*G(0)
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= i; j++) {
                total += nums[j - 1] * nums[i - j];
            }
            nums[i] = total;
        }
        return nums[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
    }

}
