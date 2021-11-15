package com.thinking.string.hard;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Longest Valid Parentheses
 * <p>
 * 题目: 给定一个字符串，仅有左括号'('和右括号')'。找到最长的子串，字串符合括号的匹配，输出符合规则括号的数目
 * <pre>
 *   input     )()())
 *   output    4
 * </pre>
 * <p>
 * 思路1: 对于字符串，我们从左往右遍历，如果发现'('，其实我们是欢迎的，因为可能后面有')'时，有最优解。
 * <p>
 * 所以，我们定义leftNum表示'('个数，rightNum表示')'个数。当leftNum==rightNum时，表示有解出现。
 * <p>
 * 但这样的算法无法解决案例: '()(()'或'())()'。为了解决这个案例，我们使用双端队列，从后往前遍历一次，以解决这个问题
 * <p>
 * 思路2：动态规划。定义dp[i][j] = dp[i-1][j-1]+2，当str[i]='('和str[j]=')'，否则dp[i][j]=0。
 * <p>
 * 类似题型: Valid Parentheses
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
