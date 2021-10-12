package com.thinking.array.medium;


import com.thinking.common.ConsoleOutput;

/**
 * Title: 132 Pattern
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/10/12
 */
public class Leetcode456 {

  public boolean find132pattern(int[] nums) {

  }

  /**
   * 动态规划，超时
   */
  public boolean find132pattern2(int[] nums) {
    int[][] dp = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          dp[i][j] = nums[i];
        } else if (i + 1 == j) {
          dp[i][j] = Math.max(nums[i], nums[j]);
        } else {
          dp[i][j] = Integer.MIN_VALUE;
        }
      }
    }
    for (int d = 2; d < nums.length; d++) {
      for (int i = 0; i + d < nums.length; i++) {
        if (nums[i] < dp[i + 1][i + d - 1] && nums[i + d] < dp[i + 1][i + d - 1]
            && nums[i] < nums[i + d]) {
          return true;
        } else {
          dp[i][i + d] = Math.max(Math.max(nums[i], nums[i + d]), dp[i + 1][i + d - 1]);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    // Outout true
//    int[] nums = {-1, 3, 2, 0};

    // Output true
    int[] nums = {3, 1, 4, 2};

    Leetcode456 leetcode456 = new Leetcode456();
    ConsoleOutput.printf(leetcode456.find132pattern(nums));
  }
}
