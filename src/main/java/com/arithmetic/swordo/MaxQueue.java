package com.arithmetic.swordo;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @version v1.0
 * @ProjectName: arithmetic
 * @ClassName: MaxQueue
 * @Description: 59 - II. 队列的最大值
 * @Author: huangdh
 * @Date: 2020/8/26 上午10:45
 */
public class MaxQueue {

    private ArrayDeque<Integer> maxQueue;
    private Queue<Integer> dataQueue;

    public MaxQueue() {
        dataQueue = new ArrayDeque<>();
        maxQueue = new ArrayDeque<>();
    }

    public int max_value() {
        if (maxQueue.isEmpty()) return -1;
        return maxQueue.peek();
    }

    public void push_back(int value) {
        dataQueue.add(value);
        if (maxQueue.isEmpty()) {
            maxQueue.add(value);
            return;
        }
        if (value > maxQueue.peek()) {
            maxQueue.clear();
        }
        while (!maxQueue.isEmpty() && value > maxQueue.peekLast()) {
            maxQueue.removeLast();
        }
        maxQueue.add(value);
    }

    public int pop_front() {
        if (dataQueue.isEmpty()) return -1;
        int value = dataQueue.poll();
        if (maxQueue.peek() == value) {
            maxQueue.poll();
        }
        return value;
    }

    public static void main(String[] args) {

        MaxQueue obj = new MaxQueue();
        obj.push_back(871);
        obj.push_back(46);
        obj.push_back(868);
        obj.push_back(868);
        obj.push_back(646);
        obj.push_back(123);
        obj.push_back(229);
        obj.push_back(871);
        obj.push_back(285);
        System.out.println("max: " + obj.max_value());
        System.out.println("pop: " + obj.pop_front());
        System.out.println("max: " + obj.max_value());
        System.out.println("pop: " + obj.pop_front());
        System.out.println("max: " + obj.max_value());
        System.out.println("pop: " + obj.pop_front());
        System.out.println("max: " + obj.max_value());
        System.out.println("pop: " + obj.pop_front());
        System.out.println("max: " + obj.max_value());
        System.out.println("pop: " + obj.pop_front());
        System.out.println("max: " + obj.max_value());
        System.out.println("pop: " + obj.pop_front());
        System.out.println("max: " + obj.max_value());
        System.out.println("pop: " + obj.pop_front());

    }

}
