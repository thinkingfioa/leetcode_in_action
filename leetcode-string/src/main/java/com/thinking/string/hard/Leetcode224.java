package com.thinking.string.hard;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Basic Calculator
 * <p>
 * 题目：给定一个字符串s，该字符串s是一个合法的计算式，求计算的数值。只会有'+'、'-'、'('和')'
 * <p>
 * 思路：由于合法的计算式中有'('和')'，需要特殊每个'('前的符号。其实对于每一对'('和')'都是一个完整的合法计算式。
 * <p>
 * 所以，对于每次遇到'('时，我们都将当前计算的结果和'('前的符号压入队列中保存起来，重新开始计算'('和')'的结果
 * <p>
 * 当遇到')'时，我们将计算出的结果与刚刚保存到队列中的值和符号做运算，算出结果
 * <p>
 * 思路2：先将合法的计算式转成逆波兰方程式，再通过计算逆波兰的算法来计算
 * <p>
 * 类似题型: Evaluate Reverse Polish Notation
 * <p>
 * Different Ways to Add Parentheses
 * <p>
 * Expression Add Operators
 * <p>
 * Basic Calculator III
 * <p>
 * The Score of Students Salving Math Expression
 *
 * @author vlin 2022/2/28
 */
public class Leetcode224 {

  /**
   * faster than 89.01%，less than 50.26%.
   */
  public int calculate(String s) {
    Deque<Integer> queue = new ArrayDeque<>();
    int sign = 1;
    int result = 0;
    int singleNum = 0;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == ' ') {
        continue;
      }
      if (c >= '0' && c <= '9') {
        singleNum = singleNum * 10 + c - '0';
      } else {
        result = result + sign * singleNum;
        singleNum = 0;
        if (c == '+') {
          sign = 1;
        } else if (c == '-') {
          sign = -1;
        } else if (c == '(') {
          queue.addLast(result);
          queue.addLast(sign);
          result = 0;
          sign = 1;
        } else if (c == ')') {
          result = queue.pollLast() * result;
          result += queue.pollLast();
        }
      }
    }

    return result + sign * singleNum;
  }

  public static void main(String[] args) {
    // Output 23
    String s = "(1+(4+5+2)-3)+6+8";

    // Output -12
//    String s = "- (3+(4+5))";

    // Output 11
//    String s = "- (3-(4+5)) + 5";

    // Output -15
//    String s = "2-4-(8+2-6+(8+4-(1)+8-10))";

    Leetcode224 leetcode224 = new Leetcode224();
    ConsoleOutput.printf(leetcode224.calculate(s));
  }
}
