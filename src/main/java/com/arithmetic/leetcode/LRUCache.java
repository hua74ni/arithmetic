package com.arithmetic.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version v1.0
 * @ProjectName: sfm
 * @ClassName: LRUCache
 * @Description: 146. LRU缓存机制
 * @Author: huangdh
 * @Date: 2020/7/30 上午10:09
 */
public class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2 /* 缓存容量 */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得关键字 1 作废
        System.out.println(cache.get(1));   // 返回 -1 (未找到)
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

    LinkedHashMap<Integer, Integer> linkedHashMap;
    private Integer maxCapacity;

    public LRUCache(Integer capacity) {
        linkedHashMap = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxCapacity;
            }
        };
        maxCapacity = capacity;
    }

    public Integer get(int key) {
        return linkedHashMap.get(key) == null ? -1 : linkedHashMap.get(key);
    }

    public void put(Integer key, Integer value) {
        linkedHashMap.put(key, value);
    }
}
