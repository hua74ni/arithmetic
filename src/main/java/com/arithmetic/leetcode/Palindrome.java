package com.arithmetic.leetcode;

/**
 * @Author huangdh
 * @Description 10. 回文数
 **/
public class Palindrome {

    public boolean isPalindrome(int x) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x);

        return stringBuilder.toString().equals(stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {

        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindrome(10));
    }

}
