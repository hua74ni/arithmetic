package com.arithmetic.swordo;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 38. 字符串的排列
 */
public class Permutation {

    private List<String> res = new LinkedList<>();
    private int length;
    private boolean[] isUsed;

    public String[] permutation(String s) {
        String[] strings = s.split("");
        Arrays.sort(strings);
        length = s.length();
        isUsed = new boolean[length];
        trackBack(strings, new StringBuilder());
        return res.toArray(new String[]{});
    }

    private void trackBack(String[] strings, StringBuilder stringBuilder) {
        if (stringBuilder.length() == length) {
            res.add(stringBuilder.toString());
            return;
        }
        for (int i = 0; i < strings.length; i++) {
            if (isUsed[i]) continue;
            if (i - 1 >= 0 && strings[i - 1].equals(strings[i]) && !isUsed[i - 1]) {
                continue;
            }
            stringBuilder.append(strings[i]);
            isUsed[i] = true;
            trackBack(strings, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        String s = "suvyls";
        String[] res = new Permutation().permutation(s);
        System.out.println(JSON.toJSONString(res));
    }

}
