package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Decode Ways
 * <p>
 * 题目: 给定一个字符串，字符串中由'0-9'数字组成，每个数组映射到'A-Z'上，比如: '1'->'A';'2'->'B'等
 * <p>
 * 求一共能解析多少种字符串.
 * <pre>
 *   Input: s="226"
 *   Output: 3。可以被解析为 "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 类似题型: Decode Ways II
 * <p>
 * Number of Ways to Separate Numbers
 *
 * @author vlin 2022/5/1
 */
public class Leetcode91 {

  /**
   * faster than 61.58%，less than 66.85%
   */
  public int numDecodings(String s) {
    if (s.isEmpty() || s.charAt(0) == '0') {
      return 0;
    }
    if (s.length() <= 1) {
      return s.length();
    }
    int[] dp = new int[s.length() + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= s.length(); i++) {
      if (s.charAt(i - 1) == '0') {
        if (s.charAt(i - 2) != '1' && s.charAt(i - 2) != '2') {
          return 0;
        } else {
          dp[i] = dp[i - 2];
        }
      } else {
        if (s.charAt(i - 2) == '0') {
          dp[i] = dp[i - 1];
        } else {
          dp[i] = dp[i - 1] + (isValid(s, i - 2, i - 1) ? dp[i - 2] : 0);
        }
      }
    }

    ConsoleOutput.printf(dp);

    return dp[s.length()];
  }

  private boolean isValid(String s, int oneIndex, int twoIndex) {
    int num = (s.charAt(oneIndex) - '0') * 10 + (s.charAt(twoIndex) - '0');
    return num >= 1 && num <= 26;
  }

  public static void main(String[] args) {
    // Output 3
//    String s = "226";
    // Output 1
    String s = "2101";

    Leetcode91 leetcode91 = new Leetcode91();
    ConsoleOutput.printf(leetcode91.numDecodings(s));
  }
}
