package com.thinking.dp.medium;


import com.thinking.common.ConsoleOutput;

/**
 * Title: Edit Distance
 * <p>
 * 题目：给定两个字符串word1和word2。要求word1通过增加、删除和替换等操作得到word2。求最少的操作数
 * <p>
 * 思路：两个字符串之间的处理比较，都可以通过动态规划实现。因为动态规划可以将前面比较的结果保存起来
 * <p>
 * 定义: dp[i][j]表示表示的是word1[0, i)通过这么多步骤操作可以得到word2[0, j)
 * <p>
 * 1. 当word1[i-1] == word2[j-1]时，dp[i][j] = dp[i-1][j-1]。无需操作
 * <p>
 * 2. 当word1[i-1] != word2[j-1]时，dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) +1。
 * <p>
 * 类似题型: One Edit Distance
 * <p>
 * Delete Operation for Two Strings
 * <p>
 * Minimum ASCII Delete Sum for Two Strings
 * <p>
 * Uncrossed Lines
 *
 * @author thinking_fioa 2021/8/4
 */
public class Leetcode72 {

  /**
   * faster than 59.69%，less than 39.16%
   */
  public int minDistance(String word1, String word2) {
    int[][] dp = new int[word1.length() + 1][word2.length() + 1];
    for (int i = 1; i <= word1.length(); i++) {
      dp[i][0] = i;
    }
    for (int j = 1; j <= word2.length(); j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= word1.length(); i++) {
      for (int j = 1; j <= word2.length(); j++) {
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        }
      }
    }
    return dp[word1.length()][word2.length()];
  }

  public static void main(String[] args) {
    // 3
//    String word1 = "horse";
//    String word2 = "ros";

    // 5
    String word1 = "intention";
    String word2 = "execution";

    // 1
//    String word1 = "a";
//    String word2 = "b";
    Leetcode72 leetcode72 = new Leetcode72();
    ConsoleOutput.printf(leetcode72.minDistance(word1, word2));
  }
}
