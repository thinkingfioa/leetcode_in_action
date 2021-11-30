package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Search a 2D Matrix II
 * <p>
 * 题目: 给定一个二维数组matrix[][]，和一个目标数字target。判断target是否在二维数字matrix[][]中存在。
 * <p>
 * 二维数组matrix[][]非常有特点：对于行，从左往右是递增的；对于列，从上往下是递增的。
 * <p>
 * 思路：
 * <p>
 * 类似题型： Paint House
 * <p>
 * Add to Array-Form of Integer
 * <p>
 * Shortest Path in a Grid with Obstacles Elimination
 *
 * @author vlin 2021/11/29
 */
public class Leetcode240 {

  /**
   * faster than 100.00%，less than 51.79%
   */
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;

    int beginRow = 0;
    int beginColumn = n - 1;

    while (beginRow < m && beginColumn >= 0) {
      if (matrix[beginRow][beginColumn] == target) {
        return true;
      } else if (matrix[beginRow][beginColumn] > target) {
        beginColumn--;
      } else {
        beginRow++;
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
