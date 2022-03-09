package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Coin Change 2
 * <p>
 * 题目: 给定一个数组coins[]和总金额amount。求从数组coins[]中选择硬币组装成总金额amount的所有组合个数，每个硬币可以使用多次
 * <p>
 * 思路：定义dp[i]表示组装成总金额i的组合个数. 那么题目开始有两种遍历方式：
 * <p>
 * 第一种：第一道for循环是[1, amount] + 第二道for循环时coins[]数组。dp[i]= dp[i]+dp[i-coin]。但这个思路有问题，
 * <p>
 * 比如dp[3]=dp[2]+dp[1]是很有问题的，如果只有一个coin=1的，这个答案明显有问题。
 * <p>
 * 第二种：第一道for循环时coins[]数组 + 第二道for循环是[coin, amount]。 dp[i]= dp[i]+dp[i-coin]。
 * <p>
 * 意味着每次我获取一个coin，都去尝试更新下dp[i]数组，这种方法可解。
 * <p>
 * 思路2：如果使用DFS方法，算法复杂度太高，会超时
 * <p>
 * 类似题型：Move Zeroes
 * <p>
 * Coin Change
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
