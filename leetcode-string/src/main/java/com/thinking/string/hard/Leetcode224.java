package com.thinking.string.hard;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Basic Calculator
 * <p>
 * 题目：给定一个字符串s，该字符串s是一个合法的计算式，求计算的数值。只会有'+'、'-'、'('和')'
 * <p>
 * 思路：
 * <p>
 * 类似题型:
 *
 * @author vlin 2022/2/28
 */
public class Leetcode224 {

  private static final char SUB = '-';
  private static final char PLUS = '+';
  private static final char LEFT = '(';
  private static final char RIGHT = ')';
  private static final char EMPTY = ' ';

  public int calculate(String s) {

    Deque<Integer> numQueue = new ArrayDeque<>();

  }

  public static void main(String[] args) {
    // Output 23
    String s = "(1+(4+5+2)-3)+6+8";

    // Output -12
//    String s = "- (3+(4+5))";

    Leetcode224 leetcode224 = new Leetcode224();
    ConsoleOutput.printf(leetcode224.calculate(s));
  }
}
