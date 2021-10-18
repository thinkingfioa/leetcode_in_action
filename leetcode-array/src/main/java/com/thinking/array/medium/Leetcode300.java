package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Longest Increasing Subsequence
 * <p>
 * 题目: 给定一个数组nums，求数组中最长的递增字串的长度（允许不连续）， 比如
 *
 * <pre>
 *   输入：1, 3, 6, 7, 9, 4, 10, 5, 6
 *   输出：6
 *   解释：1, 3, 6, 7, 9, 10是最长的自增字串
 * </pre>
 * <p>
 * 思路一：贪心 + 二分法
 * <p>
 * 思路二：动态规划，O(n^2）
 * <p>
 * 类似题型: Increasing Triplet Subsequence
 * <p>
 * Russian Doll Envelopes
 * <p>
 * Maximum Length of Pair Chain
 * <p>
 * Number of Longest Increasing Subsequence
 * <p>
 * Minimum ASCII Delete Sum for Two Strings
 * <p>
 * Minimum Number of Removals to Make Mountain Array
 * <p>
 * Find the Longest Valid Obstacle Course at Each Position
 *
 * @author thinking_fioa 2021/10/18
 */
public class Leetcode300 {

  /**
   * faster than 6.16%, less than 22.39%
   */
  public int lengthOfLIS(int[] nums) {
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      dp[i] = 1;
    }
    int result = 1;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[j] < nums[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
          result = Math.max(dp[i], result);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 4
//    int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
    int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};

    Leetcode300 leetcode300 = new Leetcode300();
    ConsoleOutput.printf(leetcode300.lengthOfLIS(nums));
  }
}
