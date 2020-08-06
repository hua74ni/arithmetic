package com.arithmetic.swordo;

import java.util.Stack;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: CQueue
 * @Description: 09. 用两个栈实现队列
 * @Author: huangdh
 * @Date: 2020/8/6 上午10:14
 */
public class CQueue {

    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if (outStack.empty()) {
            while (!inStack.empty()) {
                outStack.push(inStack.pop());
            }
        }
        if (!outStack.empty()) {
            return outStack.pop();
        }
        return -1;
    }

    public static void main(String[] args) {

        CQueue obj = new CQueue();
        System.out.println(obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }


}
