package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Subarray Sum Equals K
 * <p>
 * 题目:
 * <p>
 * 思路：
 * <p>
 * 思路2：动态规划dp[i][j]表示[i,j)的和，然后判断dp[i][j]==k，会出现Time Limit Exceeded
 * <p>
 * 类似题型：
 *
 * @author vlin 2022/3/5
 */
public class Leetcode560 {

  public int subarraySum(int[] nums, int k) {

  }

  /**
   * 运行超时，Time Limit Exceeded
   */
  public int subarraySum2(int[] nums, int k) {
    int result = 0;

    int[][] dp = new int[nums.length][nums.length + 1];
    for (int step = 1; step <= nums.length; step++) {
      for (int move = 0; move < nums.length; move++) {
        if (move + step > nums.length) {
          continue;
        }
        dp[move][move + step] = dp[move][move + step - 1] + nums[move + step - 1];
        if (dp[move][move + step] == k) {
          result++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 2
    int[] nums = {1, 1, 1};
    int k = 2;

    Leetcode560 leetcode560 = new Leetcode560();
    ConsoleOutput.printf(leetcode560.subarraySum(nums, k));
  }
}
