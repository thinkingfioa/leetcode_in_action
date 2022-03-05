package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Basic Calculator II
 * <p>
 * 题目：给定一个符合计算式的字符串，如：s = "3+2*2"，求出表达式的计算结果
 * <p>
 * 思路：由于题目中只有加，减，乘，除。定义一个变量lastOp来标记上一个操作符，所以当发现一个新的符号时，如果上次的是乘，除
 * <p>
 * 则先从队列中弹出最后一个数，进行计算结果，再把结果放进去。
 * <p>
 * 为避免减号影响计算，定义的队列中只存正数。
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
   * faster than 30.03%，less than 17.06%
   */
  public int calculate(String s) {
    s += "+0";
    Deque<Integer> numDeque = new ArrayDeque<>();
    int curNum = 0;
    char lastOp = ' ';
    for (int i = 0; i < s.length(); i++) {
      char single = s.charAt(i);
      if (single == ' ') {
        continue;
      }
      if (single >= '0' && single <= '9') {
        curNum = curNum * 10 + single - '0';
      } else {
        if (lastOp == PLUS) {
          numDeque.add(curNum);
        } else if (lastOp == SUB) {
          numDeque.add(-curNum);
        } else if (lastOp == DIV) {
          int other = numDeque.pollLast();
          numDeque.add(other / curNum);
        } else if (lastOp == MUL) {
          int other = numDeque.pollLast();
          numDeque.add(other * curNum);
        } else {
          numDeque.add(curNum);
        }
        lastOp = single;
        curNum = 0;
      }
    }
    int result = 0;
    while (!numDeque.isEmpty()) {
      result += numDeque.pollLast();
    }
    return result;
  }

  /**
   * faster than 33.93%，less than 38.51%
   */
  public int calculate2(String s) {
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
