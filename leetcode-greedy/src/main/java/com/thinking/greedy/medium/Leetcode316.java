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
 * 题目: 给一个字符串s，将字符串中重复字母去掉，并保证去掉重复字母后剩余的字符串是原串的最小字母序。
 * <p>
 * 字符串s中每个字符都是符合小写字母
 * <p>
 * 思路：去除重复字母不复杂，复杂的是要求去除重复的字母后，得到最小字母序的串。假定你当前遍历到s[i]的字母，
 * <pre>
 * s[i]字母是否会在结果串中呢？如果符合下面两个条件，则可以添加
 *    1. s[i]字母没有重复的字母了
 *    2. s[i]字母将结果串result从i-1开始依次往前找，如果发现result[i-1]>=s[i] && 原串后面中还有result[i-1]字母，
 *       则可以将结果中result[i-1]去除，再看result[i-2]字母。明显这个是一个典型的栈操作。
 * <／pre>
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
