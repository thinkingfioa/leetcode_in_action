package com.thinking.design.medium;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Title: LFU Cache
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author vlin 2021/12/27
 */
public class Leetcode460 {

  class LFUCache {

    private final int capacity;
    private int count;
    private HashMap<Integer, Integer> valueMap;
    private TreeMap<Integer, Integer> countMap;
    private TreeMap<Integer, Long> visitedMap;

    public LFUCache(int capacity) {
      this.capacity = capacity;
      this.count = 0;
      valueMap = new HashMap<>();
      countMap = new TreeMap<>();
      visitedMap = new TreeMap<>();
    }

    public int get(int key) {
      return 0;
    }

    public void put(int key, int value) {

    }

  }
}
