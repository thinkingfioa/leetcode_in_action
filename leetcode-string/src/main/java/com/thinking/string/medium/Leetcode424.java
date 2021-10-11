package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Longest Repeating Character Replacement
 * <p>
 * 题目：给定一个大写字符串s和数字k，要求：允许替换字符串s中k个字符，求：被替换后的字符串s中最长的重复字串长度
 * <p>
 * 思路：本质是一个滑动窗口题，整个窗口的大小是一个变长，其最大的窗口长度则是本题的解。
 * <p>
 * 根据贪心的思路：题目的最优解，一定是窗口中重复字符最多的才有可能是最优解
 * <p>
 * 所以，当访问一个s[index]时，窗口的右区间增大1，由于s[index]的加入变大，可能导致窗口中的重复字符变大，进而产生更优解。
 * <p>
 * 但可能k的次数已经用完，我们需要调整下窗口的左区间。找到end-begin+1==maxCount+k时，整个值end-begin+1很有可能是最优解
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
