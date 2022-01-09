package com.thinking.dp.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: House Robber
 * <p>
 * 题目: 给定一个数组nums[]，数组中每个元素nums[i]代表index=i的房间内的硬币数，如果你是一个劫匪，按照nums[]顺序
 * <p>
 * 去打家劫舍，要求不能同时抢劫两个相邻的房屋，否则就会自动触发告警。求：抢劫到最大的硬币数是多少
 * <pre>
 *   input:  2, 1, 1, 2
 *   Output: 4
 * </pre>
 * <p>
 * 思路: 题目明显是一道动态规划题目。定义dp[i]表示第i个房间时最大硬币数，且必须包括nums[i-1]。动态方程为
 * <p>
 * dp[i] = max(dp[i-2] + nums[i-1], dp[i-3]+nums[i-1])，在遍历的过程中记录最大值。
 * <p>
 * 类似题型: Maximum Product Subarray
 * <p>
 * House Robber II
 * <p>
 * Paint House
 * <p>
 * Paint Fence
 * <p>
 * House Robber III
 * <p>
 * Non-negative Integers without Consecutive Ones
 * <p>
 * Coin Path
 * <p>
 * Delete and Earn
 *
 * @author vlin 2021/12/26
 */
public class Leetcode198 {

  /**
   * faster than 100.00%，less than 84.43%
   */
  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int result = 0;
    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    dp[2] = nums[1];
    result = Math.max(dp[1], dp[2]);
    for (int i = 3; i <= nums.length; i++) {
      dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 3] + nums[i - 1]);
      result = Math.max(result, dp[i]);
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 12
//    int[] nums = {2, 7, 9, 3, 1};

    // Output 4
    int[] nums = {2, 1, 1, 2};

    Leetcode198 leetcode198 = new Leetcode198();
    ConsoleOutput.printf(leetcode198.rob(nums));
  }
}
