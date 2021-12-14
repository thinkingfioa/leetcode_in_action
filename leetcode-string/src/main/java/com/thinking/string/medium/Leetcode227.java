package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Basic Calculator II
 * <p>
 * 题目：给定一个符合计算式的字符串，如：s = "3+2*2"，求出表达式的计算结果
 * <p>
 * 思路：
 * <p>
 * 类似题型: Basic Calculator
 * <p>
 * Expression Add Operators
 * <p>
 * Basic Calculator III
 *
 * @author vlin 2021/12/14
 */
public class Leetcode227 {

  private static final char PLUS = '+';
  private static final char SUB = '-';
  private static final char DIV = '/';
  private static final char MUL = '*';

  /**
   * faster than 33.93%，less than 38.51%
   */
  public int calculate(String s) {
    s = s + "+0";
    Deque<Integer> numDeque = new ArrayDeque<>();
    Deque<Character> digitDeque = new ArrayDeque<>();
    int start = 0;
    int curNum = 0;
    while (start < s.length()) {
      char single = s.charAt(start);
      if (single == ' ') {
        start++;
        continue;
      }
      if (single == DIV || single == MUL || single == PLUS || single == SUB) {
        numDeque.add(curNum);
        curNum = 0;
        if (!digitDeque.isEmpty()
            && (digitDeque.peekLast() == DIV || digitDeque.peekLast() == MUL)) {
          if (numDeque.size() >= 2) {
            char digit = digitDeque.pollLast();
            Integer second = numDeque.pollLast();
            Integer first = numDeque.pollLast();
            if (digit == DIV) {
              numDeque.add(first / second);
            } else {
              numDeque.add(first * second);
            }
          }
        }
        digitDeque.add(single);
      } else {
        curNum = curNum * 10 + (single - '0');
      }
      start++;
    }
    numDeque.add(curNum);

//    ConsoleOutput.printf(digitDeque);
//    ConsoleOutput.printf(numDeque);

    while (!digitDeque.isEmpty()) {
      char digit = digitDeque.pollFirst();
      Integer first = numDeque.pollFirst();
      Integer second = numDeque.pollFirst();
      if (digit == PLUS) {
        numDeque.push(first + second);
      } else if (digit == SUB) {
        numDeque.push(first - second);
      } else if (digit == DIV) {
        numDeque.push(first / second);
      } else {
        numDeque.push(first * second);
      }
    }

    return numDeque.peekFirst();
  }

  public static void main(String[] args) {
    // Outout 7
    String s = "3+2*2";

    // Outout 1
//    String s = " 3/2 ";

    Leetcode227 leetcode227 = new Leetcode227();
    ConsoleOutput.printf(leetcode227.calculate(s));
  }
}
