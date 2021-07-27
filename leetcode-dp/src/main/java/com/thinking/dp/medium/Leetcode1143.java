package com.thinking.dp.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Longest Common Subsequence
 * <p>
 * 题目：
 * <p>
 * <p>
 * 思路：
 * <p>
 * 类似题型: Longest Palindromic Subsequence
 * <p>
 * Delete Operation for Two Strings
 * <p>
 * Shortest Common Supersequence
 *
 * @author thinking_fioa 2021/7/25
 */
public class Leetcode1143 {

  /**
   * faster than 86.68%，less than 86.52%
   */
  public int longestCommonSubsequence(String text1, String text2) {
    int t1 = text1.length();
    int t2 = text2.length();
    int[][] dp = new int[t1 + 1][t2 + 1];

    for (int i = 1; i <= t1; i++) {
      for (int j = 1; j <= t2; j++) {
        if (text1.charAt(i) == text2.charAt(j)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j - 1], Math.max(dp[i][j - 1], dp[i - 1][j]));
        }
      }
    }
    return dp[t1][t2];
  }

  public static void main(String[] args) {
    // Output 3
//    String text1 = "abcde";
//    String text2 = "ace";
    // Output 2
    String text1 = "ezupkr";
    String text2 = "ubmrapg";
    Leetcode1143 leetcode1143 = new Leetcode1143();
    ConsoleOutput.printf(leetcode1143.longestCommonSubsequence(text1, text2));
  }
}
