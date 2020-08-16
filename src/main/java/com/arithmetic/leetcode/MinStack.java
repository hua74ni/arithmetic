package com.arithmetic.leetcode;

import java.util.Stack;

public class MinStack {

    Stack<Integer> data;
    Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        if (min.empty() || min.peek() >= x) {
            min.push(x);
        }
    }

    public void pop() {
        int remove = data.pop();
        if (remove == min.peek()) min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(0);
        obj.push(-3);
        obj.push(-3);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

    }

}
