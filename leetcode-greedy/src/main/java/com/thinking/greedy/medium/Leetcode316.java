package com.thinking.greedy.medium;

import com.thinking.ConsoleOutput;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Title: Remove Duplicate Letters
 * <p>
 * 题目:
 * <p>
 * 思路：
 * <p>
 * 类似题型: Mini Parser
 * <p>
 * Minimum Remove to Make Valid Parentheses
 * <p>
 * Minimum Initial Energy to Finish Tasks
 */
public class Leetcode316 {

  public String removeDuplicateLetters(String s) {
    if (s.length() <= 1) {
      return s;
    }
    // key is char, value is count of duplicate
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.putIfAbsent(c, 0);
      map.computeIfPresent(c, (key, value) -> value + 1);
    }

    Set<Character> visited = new HashSet<>();
    Deque<Character> stack = new LinkedBlockingDeque<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.computeIfPresent(c, (key, value) -> value - 1);
      if (stack.isEmpty() || stack.peekLast() < c) {
        if (!visited.contains(c)) {
          stack.add(c);
          visited.add(c);
        }
      } else {
        if (visited.contains(c)) {
          continue;
        }
        while (!stack.isEmpty() && stack.peekLast() > c && map.get(stack.peekLast()) > 0) {
          visited.remove(stack.peekLast());
          stack.removeLast();
        }
        stack.add(c);
        visited.add(c);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (Character c : stack) {
      sb.append(c);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    // Output "abc"
    String s = "bcabc";
    // Output "acdb"
//    String s = "cbacdcbc";
    // Output "adbc"
//    String s = "cdadabcc";
    // Output "abc";
//    String s = "abacb";
    Leetcode316 leetcode316 = new Leetcode316();
    ConsoleOutput.printf(leetcode316.removeDuplicateLetters(s));
  }
}
