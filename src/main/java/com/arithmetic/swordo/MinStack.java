package com.arithmetic.swordo;

import java.util.Stack;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MinStack
 * @Description: 30. 包含min函数的栈
 * @Author: huangdh
 * @Date: 2020/8/12 上午10:21
 */
public class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack();
        minStack = new Stack();
    }

    public void push(int x) {
        dataStack.add(x);
        if (minStack.isEmpty() || minStack.peek() >= x) {
            minStack.push(x);
        }
    }

    public void pop() {
        int current = dataStack.pop();
        if (minStack.peek() == current) {
            minStack.pop();
        }
    }

    public int top() {
        if (dataStack.isEmpty()) return -1;
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(0);
        System.out.println(obj.min());
        obj.pop();
        System.out.println(obj.min());
    }
}
