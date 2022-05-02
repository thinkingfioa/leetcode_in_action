package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Best Time to Buy and Sell Stock III
 * <p>
 * 题目: 给定一个数组prices[]，数组中每个元素prices[i]代表当前这支股票的价格，最多只有两次操作，求最大的收益是多少。
 * <p>
 * 注意：不允许当天既卖又买
 * <pre>
 *     input: 3,3,5,0,0,3,1,4
 *     output: 6，第一个是0-3；第二个是1-4
 * </pre>
 * 思路:
 * <p>
 * 类似题型: Best Time to Buy and Sell Stock
 * <p>
 * Best Time to Buy and Sell Stock II
 * <p>
 * BestTime to Buy and Sell Stock IV
 * <p>
 * Maximum Sum of 3 Non-Overlapping Subarrays
 *
 * @author vlin 2022/4/17
 */
public class Leetcode123 {

  public int maxProfit(int[] prices) {
    int[][] dp = new int[3][2];
    dp[0][1] = -prices[0];
    dp[1][1] = -prices[0];
    dp[2][1] = -prices[0];

    for (int j = 1; j < prices.length; j++) {
      for (int k = 1; k < 3; k++) {
        dp[k][1] = Math.max(dp[k][1], dp[k - 1][0] - prices[j]);
        dp[k][0] = Math.max(dp[k][0], dp[k][1] + prices[j]);
      }
    }
    return dp[2][0];
  }

  public static void main(String[] args) {
    // Output 6
//    int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
    // Output 4
    int[] prices = {1, 2, 3, 4, 5};

    Leetcode123 leetcode123 = new Leetcode123();
    ConsoleOutput.printf(leetcode123.maxProfit(prices));
  }
}
