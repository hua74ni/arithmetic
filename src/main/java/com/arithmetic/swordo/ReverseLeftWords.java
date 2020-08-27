package com.arithmetic.swordo;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: ReverseLeftWords
 * @Description: 58 - II. 左旋转字符串
 * @Author: huangdh
 * @Date: 2020/8/26 上午9:43
 */
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder(s.substring(n));
        stringBuilder.append(s, 0, n);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords().reverseLeftWords("lrloseumgh", 1));
    }

}
