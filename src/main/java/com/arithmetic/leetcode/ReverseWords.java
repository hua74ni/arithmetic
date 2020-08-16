package com.arithmetic.leetcode;

import java.util.Arrays;
import java.util.List;

public class ReverseWords {

    public String reverseWords(String s) {
        if (s == null) return s;
        s = s.trim(); // remove head tail space
        if (s.length() <= 1) return s;

        List<String> words = Arrays.asList(s.split("\\s+"));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            if (stringBuilder.length() == 0)
                stringBuilder.append(words.get(i));
            else
                stringBuilder.append(" ").append(words.get(i));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {

        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }

}
