package com.thinking.string.hard;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Longest Valid Parentheses
 * <p>
 * 题目:
 * <p>
 * 思路1:
 * <p>
 * 思路2：
 * <p>
 * 类似题型:
 *
 * @author vlin 2021/11/10
 */
public class Leetcode32 {

  private static final Character LEFT = '(';
  private static final Character RIGHT = ')';

  /**
   * faster than 43.97%，less than 56.37%
   */
  public int longestValidParentheses(String s) {
    if (null == s || s.isEmpty()) {
      return 0;
    }
    Deque<Character> deque = new ArrayDeque<>();
    int result = -1;
    int leftNum = 0;
    int rightNumber = 0;
    for (int i = 0; i < s.length(); i++) {
      Character c = s.charAt(i);
      if (c == LEFT) {
        // '('
        leftNum++;
        deque.addLast(LEFT);
      } else {
        // ')'
        if (leftNum > rightNumber) {
          rightNumber++;
          deque.addLast(RIGHT);
        } else {
          result = Math.max(result, rightNumber);
          leftNum = 0;
          rightNumber = 0;
          deque.clear();
        }
      }
    }

    leftNum = 0;
    rightNumber = 0;
    while (!deque.isEmpty()) {
      Character last = deque.pollLast();
      if (last == RIGHT) {
        // ')'
        rightNumber++;
      } else {
        // '('
        if (rightNumber > leftNum) {
          leftNum++;
        } else {
          result = Math.max(result, leftNum);
          leftNum = 0;
          rightNumber = 0;
        }
      }
    }

    result = Math.max(result, Math.min(leftNum, rightNumber));
    return result * 2;
  }

  public static void main(String[] args) {
    // Output 6
//    String s = "(()())(";

    // Output 2
//    String s = "()(()";

    // Output 2
    String s = "()";

    Leetcode32 leetcode32 = new Leetcode32();
    ConsoleOutput.printf(leetcode32.longestValidParentheses(s));
  }
}
