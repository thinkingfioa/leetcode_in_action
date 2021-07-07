package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Maximum Length of Repeated Subarray
 * <p>
 * 题目:
 * <p>
 * 思路1: 滑动窗口。
 * <p>
 * 思路2: 动态规划
 * <p>
 * 类似题型: Minimum Size Subarray Sum
 *
 * @author thinking_fioa 2021/7/7
 */
public class Leetcode718 {

  /**
   * 方法一：滑动窗口 faster than 89.42%, less than 92.20%
   */
  public int findLength(int[] nums1, int[] nums2) {
    int result = maxResult(nums1, nums2);
    return Math.max(result, maxResult(nums2, nums1));
  }

  public int maxResult(int[] base, int[] move) {
    int result = 0;
    // 以base为基准，move去对
    for (int i = 0; i < base.length; i++) {
      int count = 0;
      int k = i;
      for (int j = 0; j < move.length && k < base.length; j++, k++) {
        if (move[j] == base[k]) {
          count++;
          result = Math.max(result, count);
        } else {
          count = 0;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // output 3
//    int[] nums1 = {1, 2, 3, 2, 1};
//    int[] nums2 = {3, 2, 1, 4, 7};
    // output 4
    int[] nums1 = {0, 0, 0, 0, 1};
    int[] nums2 = {1, 0, 0, 0, 0};
    Leetcode718 leetcode718 = new Leetcode718();
    ConsoleOutput.printf(leetcode718.findLength(nums1, nums2));
  }
}
