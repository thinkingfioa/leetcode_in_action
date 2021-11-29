package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Search a 2D Matrix II
 * <p>
 * 题目:
 * <p>
 * 思路：
 * <p>
 * 误区：二分法求解
 * <p>
 * 类似题型：
 *
 * @author vlin 2021/11/29
 */
public class Leetcode240 {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    if (m == 1 && n == 1) {
      return matrix[0][0] == target;
    }

    int row = 0;
    int beginColumn = 0;
    int endColumn = n - 1;
    while (beginColumn < endColumn) {
      int mid = (beginColumn + endColumn) / 2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] < target) {
        beginColumn = mid + 1;
      } else {
        endColumn = mid - 1;
      }
    }

    ConsoleOutput.printf(beginColumn);
    ConsoleOutput.printf(endColumn);

    for (int column = endColumn; column >= 0 && column >= endColumn - 1;
        column--) {
      int beginRow = 0;
      int endRow = m - 1;
      while (beginRow <= endRow) {
        int mid = (beginRow + endRow) / 2;
        if (matrix[mid][column] == target) {
          return true;
        } else if (matrix[mid][column] < target) {
          beginRow = mid + 1;
        } else {
          endRow = mid - 1;
        }
      }
    }

    return false;
  }

  public static void main(String[] args) {
    // Output true
    int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22},
        {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
    int target = 13;

//    int[][] matrix = {{-5}};
//    int target = -5;

    Leetcode240 leetcode240 = new Leetcode240();
    ConsoleOutput.printf(leetcode240.searchMatrix(matrix, target));
  }
}
