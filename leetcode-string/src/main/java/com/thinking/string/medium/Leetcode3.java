package com.thinking.string.medium;

import com.thinking.ConsoleOutput;
import java.util.HashMap;

/**
 * Title: Longest Substring Without Repeating Characters
 * <p>
 * 题目: 给定一个字符串，查找出最长子串，该子串中没有重复的字符
 * <p>
 * 思路: 当找到重复的字符后，那么下个可能的最长字串起点只能是该字符的下一个点。如果该字符串没有重复的字符，那么应该是字符串的总长度
 * <p>
 * 类似题型: Longest Substring with At Most Two Distinct Characters;
 * <p>
 * Longest Substring with At Most K Distinct Characters;
 * <p>
 * Subarrays with K Different Integers;
 *
 * @author thinking_fioa 2021/3/8
 */
public class Leetcode3 {

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    HashMap<Character, Integer> visited = new HashMap<>();
    int maxResult = -1;
    int calBeginIndex = -1;
    for (int start = 0; start < s.length(); start++) {
      Character oneC = s.charAt(start);
      if (visited.containsKey(oneC)) {
        // 解决abba的问题，calBeginIndex不能往小的走
        calBeginIndex = Math.max(calBeginIndex, visited.get(oneC));
      }
      maxResult = Math.max(maxResult, start - calBeginIndex);
      visited.put(oneC, start);
    }

    return maxResult;
  }

  public static void main(String[] args) {
    // Expected 7
//    String s = "abcdefg";
    // Expected 2
//    String s = "aab";
    // Expected 2
//    String s = "cdd";
    // Expected 2
    String s = "abba";
    Leetcode3 leetcode3 = new Leetcode3();
    ConsoleOutput.printf(leetcode3.lengthOfLongestSubstring(s));
  }

}
