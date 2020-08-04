package com.arithmetic.leetcode;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: IsPalindrome
 * @Description: 125. 验证回文串
 * @Author: huangdh
 * @Date: 2020/7/21 上午11:10
 */
public class IsPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                stringBuilder.append(c);
            }
            if (c >= 'A' && c <= 'Z') {
                stringBuilder.append((char) (c + 32));
            }
        }
        String str = stringBuilder.toString();
        String reverse = stringBuilder.reverse().toString();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != reverse.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new IsPalindrome().isPalindrome(s));
    }

}
