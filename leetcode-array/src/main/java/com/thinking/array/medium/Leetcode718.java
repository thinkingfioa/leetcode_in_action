package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Maximum Length of Repeated Subarray
 * <p>
 * 题目: 给定两个数组nums1[]和nums2[]，求两个数组中最长相同的字数组
 * <p>
 * 思路1: 滑动窗口。求两个数组nums1[]和nums2[]的最长字数组，
 * <p>
 * 如果我们想下，以nums1[]为基础，遍历nums1[]中的每个元素，去nums2[]中找，如果相等就依次遍历最长的个数。这种算法能解决
 * <p>
 * nums1[]={1, 0, 0, 0}和nums2[]={0, 0, 0, 1}的场景，但是解决不了nums1[0, 0, 0, 1}和nums2[]={1, 0, 0, 0}场景
 * <p>
 * 所以可以两次交换获取最大即可。
 * <p>
 * 思路2: 动态规划。定义动态方程dp[i][j]表示nums1[i:]和nums2[j:]两个子数组的相同前缀的长度。
 * <p>
 * dp[i][j]=0(当num1[i]!=num[j])，dp[i][j]=dp[i+1][j+1]+1(当num1[i]==num[j])
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
