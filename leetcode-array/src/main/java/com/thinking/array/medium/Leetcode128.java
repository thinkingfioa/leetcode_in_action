package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: Longest Consecutive Sequence
 * <p>
 * 题目: 给定一个未排序的数组nums[]，求出数组中连续数字的最大长度。要求时间复杂度为O(n)
 * <p>
 * 思路：
 * <p>
 * 类似题型：Binary Tree Longest Consecutive Sequence
 *
 * @author vlin 2021/11/30
 */
public class Leetcode128 {

  /**
   * faster than 35.53%， less than 17.02%
   */
  public int longestConsecutive(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int result = 0;
    Map<Integer, Integer> markMap = new HashMap<>();
    for (int single : nums) {
      if (!markMap.containsKey(single)) {
        int left = markMap.getOrDefault(single - 1, 0);
        int right = markMap.getOrDefault(single + 1, 0);
        result = Math.max(result, left + right + 1);
        markMap.put(single, left + right + 1);
        markMap.put(single - left, left + right + 1);
        markMap.put(single + right, left + right + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 9
    int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

    Leetcode128 leetcode128 = new Leetcode128();
    ConsoleOutput.printf(leetcode128.longestConsecutive(nums));
  }
}
