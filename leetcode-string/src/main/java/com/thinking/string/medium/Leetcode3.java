package com.thinking.string.medium;

import com.thinking.ConsoleOutput;
import java.util.HashMap;

/**
 * Title: Longest Substring Without Repeating Characters
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/3/8
 */
public class Leetcode3 {

  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    HashMap<Character, Integer> visited = new HashMap<>();
    int maxResult = 0;
    int markBegin = 0;
    for (int start = 0; start < s.length(); start++) {
      Character oneC = s.charAt(start);
      if (visited.containsKey(oneC)) {
        if (visited.get(oneC) < markBegin) {
          maxResult = Math.max(maxResult, (start - markBegin + 1));
          visited.put(oneC, start);
        } else {
          maxResult = Math.max(maxResult, (start - visited.get(oneC)));
          markBegin = visited.get(oneC) + 1;
          visited.put(oneC, start);
        }
      } else {
        maxResult = Math.max(maxResult, (start - markBegin + 1));
        visited.put(oneC, start);
      }
    }

    return maxResult;
  }

  public static void main(String[] args) {
    // Expected 7
    String s = "abcdefg";
    // Expected 2
//    String s = "aab";
    // Expected 2
//    String s = "cdd";
    // Expected 2
//    String s = "abba";
    Leetcode3 leetcode3 = new Leetcode3();
    ConsoleOutput.printf(leetcode3.lengthOfLongestSubstring(s));
  }

}
