package com.thinking.dp.easy;

/**
 * 给定一个数组nums，寻找子数组元素相加和最大
 *
 * 第一种方法：动态规划。
 * <pre>
 *   1. 如果定义dp[i][len]表示nums[i，i+len-1]区间最大子序列和，会内存溢出.
 *   2. 定义dp[i]表示，以nums[i]结尾，最大的子序列和. dp[i]= dp[i-1]>0?dp[i-1]+nums[i]:nums[i]
 * </pre>
 *
 *
 * 第二种方法：分而治之. 可参考Go语言分而治之做法. left - mid - right
 *
 * <pre>
 *   https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 15/09/2019
 */
public class Leetcode53 {

  /**
   * dp[i]= dp[i-1]>0? dp[i-1]+nums[i]: nums[i]
   */
  public int maxSubArray(int[] nums) {
    int last = nums[0];
    int maxResult = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (last > 0) {
        last = last + nums[i];
      } else {
        last = nums[i];
      }
      maxResult = Math.max(maxResult, last);
    }
    return maxResult;
  }

  /**
   * dp[i][len] = max(result, max(dp[i][len-1]+nums[i+len-1]) 内存溢出
   */
  public int maxSubArrayOutOfMemory(int[] nums) {
    int result = Integer.MIN_VALUE;

    int[][] dp = new int[nums.length][nums.length + 1];

    for (int len = 1; len <= nums.length; len++) {
      for (int i = 0; i + len <= nums.length; i++) {
        dp[i][len] = dp[i][len - 1] + nums[i + len - 1];
        result = Math.max(result, dp[i][len]);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    Leetcode53 leetcode53 = new Leetcode53();

    System.out.printf("%d\n", leetcode53.maxSubArray(nums));
  }

}
