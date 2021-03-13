package com.thinking.string.medium;

import com.thinking.ConsoleOutput;

/**
 * Title: Longest Palindromic Substring
 * <p>
 * 题目: 给定一个字符串string，找出字符串中的最长回文子串。
 * <p>
 * 思路1: 动态规划。s[i][j]用来表示字符串[i, j]是否是回文串，s[i][j]=1表示是回文串，s[i][j]=0表示不是回文串。
 * <p>
 * 递归方程是s[i][j]可以根据s[i-1][j-1] && s[i] == s[j]来判断类推，进而得到最长的回文子串。时间复杂度O(n^2)
 * <p>
 * 思路2: 使用Manacher算法算法，可以得到O(n)时间复杂度的算法
 * <p>
 * 类似题型: Shortest Palindrome
 * <p>
 * Palindrome Pairs
 * <p>
 * Longest Palindromic Subsequence
 * <p>
 * Palindromic Substrings
 *
 * @author thinking_fioa 2021/3/11
 */
public class Leetcode5 {

  public String longestPalindrome(String s) {
    if (s.isEmpty()) {
      return "";
    }
    int len = s.length();
    int[][] dp = new int[len][len];
    for (int i = 0; i < len; i++) {
      dp[i][i] = 1;
    }

    String result = s.substring(0, 1);
    // 动态规划
    for (int i = 1; i < len; i++) {
      for (int j = 0; j + i < len; j++) {
        if ((j + 1 > j + i - 1 || dp[j + 1][j + i - 1] == 1) && s.charAt(j) == s.charAt(j + i)) {
          dp[j][j + i] = 1;
          result = s.substring(j, j + i + 1);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Leetcode5 leetcode5 = new Leetcode5();
    // Expected "aba"
//    String s = "babad";
    // Expected "bb"
//    String s = "cbbd";
    // Expected "a"
//    String s = "a";
    // Expected "a"
    String s = "ac";
    ConsoleOutput.printf(leetcode5.longestPalindrome(s));
  }
}
