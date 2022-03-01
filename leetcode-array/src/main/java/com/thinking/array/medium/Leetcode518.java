package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Coin Change 2
 * <p>
 * 题目: 给定一个数组coins[]和总金额amount。求从数组coins[]中选择硬币组装成总金额amount的所有组合，每个硬币可以使用多次
 * <p>
 * 思路：
 * <p>
 * 思路2：如果使用DFS方法，算法复杂度太高，会超时
 * <p>
 * 类似题型：Move Zeroes
 * <p>
 * Search Suggestions System
 * <p>
 * GCD Sort of An Array
 *
 * @author vlin 2022/3/1
 */
public class Leetcode518 {

  /**
   * faster than 71.55%，less than 52.38%
   */
  public int change(int amount, int[] coins) {

    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        if (i - coin >= 0) {
          dp[i] = dp[i] + dp[i - coin];
        }
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    // Output 4
    int amount = 5;
    int[] coins = {1, 2, 5};

    // Output
//    int amount = 500;
//    int[] coins = {3, 5, 7, 8, 9, 10, 11};

    Leetcode518 leetcode518 = new Leetcode518();
    ConsoleOutput.printf(leetcode518.change(amount, coins));
  }
}
