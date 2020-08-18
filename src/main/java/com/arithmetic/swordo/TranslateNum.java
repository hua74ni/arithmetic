package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: TranslateNum
 * @Description: 46. 把数字翻译成字符串
 * @Author: huangdh
 * @Date: 2020/8/18 上午10:00
 */
public class TranslateNum {

    public int translateNum(int num) {
        String string = String.valueOf(num);
        char[] chars = string.toCharArray();
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < chars.length + 1; i++) {
            if (chars[i - 2] != '0' && "25".compareTo(string.substring(i - 2, i)) >= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[chars.length];
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(26));

    }

}
