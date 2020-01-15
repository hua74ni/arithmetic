package com.arithmetic.leetcode;

/**
 * @Author huangdh
 * @Description 14. 最长公共前缀
 **/
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder stringBuilder = new StringBuilder();
        String standardStr = strs[0];
        char currentStr;
        boolean goOn = true;

        for (int i = 0; goOn && i <standardStr.length() ; i++) {
            currentStr = standardStr.charAt(i);
            for (int j = 1; goOn && j < strs.length; j++) {
                if (strs[j].length() - 1 < i || strs[j].charAt(i) != currentStr) {
                    goOn = false;
                }
            }

            if (goOn) {
                stringBuilder.append(standardStr.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"aa","a"}));
    }

}
