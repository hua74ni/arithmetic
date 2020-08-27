package com.arithmetic.swordo;

import java.util.Stack;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: ReverseWords
 * @Description: 58 - I. 翻转单词顺序
 * @Author: huangdh
 * @Date: 2020/8/25 上午10:29
 */
public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();
        int start = 0;
        int end = 0;
        Stack<String> stack = new Stack();
        for (int i = 0; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) == ' ') {
                stack.add(s.substring(start, end));
                end++;
                while (i + 1 < s.length() && s.charAt(i + 1) == ' ') {
                    i++;
                    end++;
                }
                start = end;
            } else {
                end++;
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop() + " ");
        }
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }

}
