package com.thinking.dp.medium;

import com.thinking.common.ConsoleOutput;
import java.util.Arrays;

/**
 * Title: Coin Change
 * <p>
 * 题目: 给定一个数组coins[]，和一个数字amount。从数组coins[]中选择硬币，组合成amount，要求用最少的硬币个数
 *
 * <pre>
 *   input:  1, 2, 5
 *   output: 11 = 5 + 5 + 1 = 3
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 类似题型: Minimum Cost For Tickets
 *
 * @author vlin 2021/11/15
 */
public class Leetcode322 {

  /**
   * faster than 67.18%， less than 72.43%
   */
  public int coinChange(int[] coins, int amount) {
    if (0 == amount) {
      return 0;
    }

    int[] dp = new int[amount];
    Arrays.fill(dp, Integer.MAX_VALUE);
    for (int coin : coins) {
      if (coin <= amount) {
        dp[coin - 1] = 1;
      }
    }
    for (int i = 0; i < amount; i++) {
      for (int coin : coins) {
        if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
          dp[i] = Math.min(dp[i], dp[i - coin] + 1);
        }
      }
    }

    return dp[amount - 1] == Integer.MAX_VALUE ? -1 : dp[amount - 1];
  }

  public static void main(String[] args) {
    // Output 3
//    int[] coins = {1, 2, 5};
//    int amount = 11;

    // Output -1
    int[] coins = {2};
    int amount = 3;

    Leetcode322 leetcode322 = new Leetcode322();
    ConsoleOutput.printf(leetcode322.coinChange(coins, amount));
  }
}
