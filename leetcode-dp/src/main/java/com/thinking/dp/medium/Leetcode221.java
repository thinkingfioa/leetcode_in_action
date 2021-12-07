package com.thinking.dp.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Maximal Square
 * <p>
 * 题目: 给定一个二维数组matrix[m][n]，数组中每个元素是'1'或'0'，求有'1'组成的最大正方形区域大小
 * <pre>
 *   input:  {'1', '0', '1', '0', '0'},
 *           {'1', '0', '1', '1', '1'},
 *           {'1', '1', '1', '1', '1'},
 *           {'1', '0', '0', '1', '0'}
 *   output: 4
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 类似题型: Maximal Rectangle
 * <p>
 * Largest Plus Sign
 *
 * @author vlin 2021/12/7
 */
public class Leetcode221 {

  /**
   * faster than 30.55%，less than 29.49%
   */
  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    if (matrix.length == 1) {
      for (char single : matrix[0]) {
        if (single == '1') {
          return 1;
        }
      }
      return 0;
    }

    int m = matrix.length;
    int n = matrix[0].length;
    int[][] dp = new int[m][n];
    int result = 0;
    for (int row = 0; row < m; row++) {
      for (int column = 0; column < n; column++) {
        if (row == 0 || column == 0) {
          dp[row][column] = matrix[row][column] == '1' ? 1 : 0;
          result = Math.max(result, dp[row][column]);
        } else if (matrix[row][column] == '1') {
          dp[row][column] = Math.min(Math.min(dp[row - 1][column], dp[row][column - 1]),
              dp[row - 1][column - 1]) + 1;
          result = Math.max(result, dp[row][column]);
        } else {
          dp[row][column] = 0;
        }
      }
    }
    return result * result;
  }

  public static void main(String[] args) {
    // Output 4
//    char[][] matrix = {{'1', '0', '1', '0', '0'},
//        {'1', '0', '1', '1', '1'},
//        {'1', '1', '1', '1', '1'},
//        {'1', '0', '0', '1', '0'}};

    // Output 1
    char[][] matrix = {{'0', '1'},
        {'1', '0'}};

    // Output 9
//    char[][] matrix = {{'0', '0', '1', '0'},
//        {'1', '1', '1', '1'},
//        {'1', '1', '1', '1'},
//        {'1', '1', '1', '0'},
//        {'1', '1', '0', '0'},
//        {'1', '1', '1', '1'},
//        {'1', '1', '1', '0'}};

    Leetcode221 leetcode221 = new Leetcode221();
    ConsoleOutput.printf(leetcode221.maximalSquare(matrix));
  }
}
