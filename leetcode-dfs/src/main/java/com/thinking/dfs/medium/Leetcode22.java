package com.thinking.dfs.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title: Generate Parentheses
 * <p>
 * 题目: 给一个n对的括号，要求输出所有符合括号形式的组合
 * <pre>
 *     输入：3
 *     输出：["((()))","(()())","(())()","()(())","()()()"]
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 类似题型: Valid Parentheses
 *
 * @author vlin 2021/11/16
 */
public class Leetcode22 {

  private static final String LEFT = "(";
  private static final String RIGHT = ")";

  /**
   * faster than 5.26%，less than 34.00%
   */
  public List<String> generateParenthesis(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    Set<String> listSet = new HashSet<>();
    dfs(listSet, "", 2 * n, 0, 0);
    return new ArrayList<>(listSet);
  }

  public void dfs(Set<String> listSet, String result, int n, int leftNum, int rightNum) {
    if (n == 0 && leftNum == rightNum && !listSet.contains(result)) {
      listSet.add(result);
      return;
    }
    if (n < 0) {
      return;
    }

    dfs(listSet, result + LEFT, n - 1, leftNum + 1, rightNum);

    String tmpResult = result;
    int tmpN = n;
    for (int beginRightNum = rightNum + 1; beginRightNum <= leftNum; beginRightNum++) {
      tmpResult = tmpResult + RIGHT;
      tmpN = tmpN - 1;
      dfs(listSet, tmpResult, tmpN, leftNum, beginRightNum);
    }
  }

  public static void main(String[] args) {
    // Output ["((()))","(()())","(())()","()(())","()()()"]
//    int n = 3;

    // Output ["()"]
    int n = 1;
    Leetcode22 leetcode22 = new Leetcode22();
    ConsoleOutput.printf(leetcode22.generateParenthesis(n));
  }
}
