package com.arithmetic.swordo;

import java.util.*;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: FirstUniqChar
 * @Description: 50. 第一个只出现一次的字符
 * @Author: huangdh
 * @Date: 2020/8/20 上午9:56
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i))) {
                int index = list.indexOf(s.charAt(i));
                if (index != -1) list.remove(index);
            } else {
                list.add(s.charAt(i));
            }
        }
        return list.isEmpty() ? ' ' : list.getFirst();
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar("aadadaad"));
    }

}
