package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Longest Increasing Path in a Matrix
 * <p>
 * 题目:
 * <pre>
 *   input:    9   9   4
 *             6   6   8
 *             2   1   1
 *   output: 4. 1->2->6->9
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author vlin 2022/4/24
 */
public class Leetcode329 {

  /**
   * faster than 91.34%，less than 75.81%
   */
  public int longestIncreasingPath(int[][] matrix) {
    int row = matrix.length;
    int column = matrix[0].length;
    int[][] lenPath = new int[row][column];
    int[][] visited = new int[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        lenPath[i][j] = 1;
        visited[i][j] = 0;
      }
    }

    int result = 1;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (visited[i][j] == 1) {
          result = Math.max(result, lenPath[i][j]);
        } else {
          dfsFind(matrix, visited, lenPath, i, row, j, column, 0);
          result = Math.max(result, lenPath[i][j]);
          visited[i][j] = 1;
        }
      }
    }

    return result;
  }

  private int dfsFind(int[][] matrix, int[][] visited, int[][] lenPath, int i, int row,
      int j, int column, int curLen) {
    if (i >= row || j >= column) {
      return curLen;
    }

    if (visited[i][j] == 1) {
      return curLen + lenPath[i][j];
    }

    visited[i][j] = 1;
    int tmpMax = 1;
    // to left
    if (j - 1 >= 0 && matrix[i][j] < matrix[i][j - 1]) {
      tmpMax = Math.max(tmpMax, dfsFind(matrix, visited, lenPath, i, row, j - 1, column, 1));
    }
    // to right
    if (j + 1 < column && matrix[i][j] < matrix[i][j + 1]) {
      tmpMax = Math.max(tmpMax, dfsFind(matrix, visited, lenPath, i, row, j + 1, column, 1));
    }
    // to up
    if (i - 1 >= 0 && matrix[i][j] < matrix[i - 1][j]) {
      tmpMax = Math.max(tmpMax, dfsFind(matrix, visited, lenPath, i - 1, row, j, column, 1));
    }
    // to down
    if (i + 1 < row && matrix[i][j] < matrix[i + 1][j]) {
      tmpMax = Math.max(tmpMax, dfsFind(matrix, visited, lenPath, i + 1, row, j, column, 1));
    }
    lenPath[i][j] = tmpMax;

    return curLen + tmpMax;
  }

  public static void main(String[] args) {
    // Output 4
//    int[][] martix = {{9, 9, 4}, {6, 6, 8}, {2, 1, 1}};
    // Output 9
    int[][] martix = {{9, 8, 7}, {4, 5, 6}, {3, 2, 1}};

    Leetcode329 leetcode329 = new Leetcode329();
    ConsoleOutput.printf(leetcode329.longestIncreasingPath(martix));
  }
}
