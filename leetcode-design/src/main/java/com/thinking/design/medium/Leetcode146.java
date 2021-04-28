package com.thinking.design.medium;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Title: LRU Cache
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: LFU Cache
 * <p>
 * Design In-Memory File System
 * <p>
 * Design Compressed String Iterator
 * <p>
 * Design Most Recently Used Queue
 *
 * @author thinking_fioa 2021/4/25
 */
public class Leetcode146 {

  class LRUCache {

    private final int maxCapacity;

    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>() {
      @Override
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > maxCapacity;
      }
    };

    public LRUCache(int capacity) {
      this.maxCapacity = capacity;
    }

    public int get(int key) {
      Integer value = map.get(key);
      if (null == value) {
        return -1;
      }
      map.remove(key);
      map.put(key, value);
      return value;
    }

    public void put(int key, int value) {
      if (map.containsKey(key)) {
        map.remove(key);
      }
      map.put(key, value);
    }
  }


  public static void main(String[] args) {

  }
}
