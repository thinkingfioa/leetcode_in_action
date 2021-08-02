package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Longest Repeating Character Replacement
 * <p>
 * 题目：
 * <p>
 * 思路：
 * <p>
 * 类似题型: Longest Substring with At Most K Distinct Characters
 * <p>
 * Max Consecutive Ones III
 *
 * @author thinking_fioa 2021/7/29
 */
public class Leetcode424 {

  /**
   * faster than 94.85%，ess than 41.28%
   */
  public int characterReplacement(String s, int k) {
    int[] letterArray = new int[26];
    int begin = 0;
    int maxCount = 0;
    int result = 0;
    for (int end = 0; end < s.length(); end++) {
      letterArray[s.charAt(end) - 'A']++;
      maxCount = Math.max(letterArray[s.charAt(end) - 'A'], maxCount);
      while (end - begin + 1 > maxCount + k) {
        letterArray[s.charAt(begin) - 'A']--;
        begin++;
      }
      result = Math.max(result, end - begin + 1);
    }
    return result;
  }

  public static void main(String[] args) {
    // 4
//    String s = "ABAB";
//    int k = 2;
    // 4
    String s = "AABABBA";
    int k = 1;
    Leetcode424 leetcode424 = new Leetcode424();
    ConsoleOutput.printf(leetcode424.characterReplacement(s, k));
  }
}
