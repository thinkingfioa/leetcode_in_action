package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Title: Minimum Window Substring
 * <p>
 * 题目：给定一个字符串s和字符串t，要求求出字符串s的连续字串包含所有字符串t，这个连续子串的长度要保证最小。测试用例保证答案唯一
 * <p>
 * 思路：第一步: 需要思考的是，如何判断出字符串t在字串s'中每个元素都有。我们利用的Map，将两个字符串转换成Map，通过比较Map来判断相等
 * <p>
 * 第二步: 如何求出长度最小，其实这个很自然想到的就是滑动窗口当发现右边界中可以得到结果时，通过收缩左边界来尝试算出最短的解
 * <p>
 * 类似题型: Substring with Concatenation Of All Words
 * <p>
 * Minimum Size Subarray Sum
 * <p>
 * Sliding Window Maximum
 * <p>
 * Permutation in String
 * <p>
 * Smallest Range Covering Elements from K Lists
 * <p>
 * Minimum Window Subsequence
 *
 * @author thinking_fioa 2021/8/8
 */
public class Leetcode76 {

  /**
   * faster than 5.03%, less than 38.58%。通过率低，但是思路与通过率高的一模一样
   */
  public String minWindow(String s, String t) {
    if (s.length() < t.length()) {
      return "";
    }
    Map<Character, Integer> tMap = new HashMap<>();
    for (int i = 0; i < t.length(); i++) {
      char c = t.charAt(i);
      tMap.putIfAbsent(c, 0);
      tMap.computeIfPresent(c, (k, v) -> v + 1);
    }
    String result = "";
    int left = 0;
    Map<Character, Integer> sMap = new HashMap<>();
    for (int right = 0; right < s.length(); right++) {
      char c = s.charAt(right);
      sMap.putIfAbsent(c, 0);
      sMap.computeIfPresent(c, (k, v) -> v + 1);
      if (haveMap(tMap, sMap)) {
        result = minStr(result, s.substring(left, right + 1));
        while (left - 1 + t.length() <= right) {
          sMap.computeIfPresent(s.charAt(left), (k, v) -> v - 1);
          if (!haveMap(tMap, sMap)) {
            sMap.computeIfPresent(s.charAt(left), (k, v) -> v + 1);
            break;
          } else {
            left++;
            result = minStr(result, s.substring(left, right + 1));
          }
        }
      }
    }
    return result;
  }

  private String minStr(String str1, String str2) {
    if ("".equals(str1)) {
      return str2;
    }
    if (str1.length() <= str2.length()) {
      return str1;
    }
    return str2;
  }

  private boolean haveMap(Map<Character, Integer> tMap, Map<Character, Integer> sMap) {
    Set<Map.Entry<Character, Integer>> tEntrySet = tMap.entrySet();
    for (Map.Entry<Character, Integer> entry : tEntrySet) {
      Integer fValue = sMap.get(entry.getKey());
      if (fValue == null || fValue < entry.getValue()) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    // BANC
    String s = "ADOBECODEBANC";
    String t = "ABC";
    Leetcode76 leetcode76 = new Leetcode76();
    ConsoleOutput.printf(leetcode76.minWindow(s, t));
  }
}
