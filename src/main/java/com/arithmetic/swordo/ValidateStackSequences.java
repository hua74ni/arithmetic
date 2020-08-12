package com.arithmetic.swordo;

import java.util.Stack;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: ValidateStackSequences
 * @Description: 31. 栈的压入、弹出序列
 * @Author: huangdh
 * @Date: 2020/8/12 上午10:46
 */
public class ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int popIndex = 0;
        for (int i = 0; i < pushed.length; i++) {
            if (pushed[i] == popped[popIndex]) {
                popIndex++;
            } else {
                stack.push(pushed[i]);
            }
            while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
                popIndex++;
                stack.pop();
            }
        }
        while (!stack.isEmpty() && stack.peek() == popped[popIndex]) {
            popIndex++;
            stack.pop();
        }
        return popIndex == pushed.length ? true : false;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{2, 1, 0};
        int[] popped = new int[]{1, 2, 0};

        System.out.println(new ValidateStackSequences().validateStackSequences(pushed, popped));
    }

}
