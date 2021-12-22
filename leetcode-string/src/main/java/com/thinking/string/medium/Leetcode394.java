package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Decode String
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author vlin 2021/12/22
 */
public class Leetcode394 {

  private static final Character LEFT_SQUARE = '[';
  private static final Character RIGHT_SQUARE = ']';

  public String decodeString(String s) {
    Deque<String> deque = new ArrayDeque();

    
  }

  private boolean isNum(Character c) {
    return c >= '0' && c <= '9';
  }

  public static void main(String[] args) {
//    // Output accaccacc
//    String s = "3[a2[c]]";

    // Output abcabccdcdcdef
    String s = "2[abc]3[cd]ef";

    Leetcode394 leetcode394 = new Leetcode394();
    ConsoleOutput.printf(leetcode394.decodeString(s));
  }
}
