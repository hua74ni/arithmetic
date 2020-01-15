package com.arithmetic.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: IsValid
 * @Description: 20. 有效的括号
 * @Author: huangdh
 * @Date: 2020/1/15 下午4:02
 */
public class IsValid {

    public boolean isValid(String s) {

        boolean result = true;

        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (map.get(s.charAt(i)) == null) {
                if (stack.empty() || stack.pop() != s.charAt(i)) {
                    result = false;
                    break;
                }
            } else {
                stack.push(map.get(s.charAt(i)));
            }
        }

        if (!stack.empty()) {
            result = false;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("(()[]{}"));

    }

}
