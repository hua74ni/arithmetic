package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: ReplaceSpace
 * @Description: 05. 替换空格
 * @Author: huangdh
 * @Date: 2020/8/5 下午6:32
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                stringBuilder.append("%20");
            } else{
                stringBuilder.append(chars[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(new ReplaceSpace().replaceSpace("We are happy."));
    }

}
