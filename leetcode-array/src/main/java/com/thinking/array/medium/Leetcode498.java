package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Diagonal Traverse
 * <p>
 * 题目: 给定一个二维数组mat[i][j]，要求按照固定的顺序输出二维住宿。先从斜上输出，再斜下输出，循环轮转
 *
 * <pre>
 *   input:  1   2   3
 *           4   5   6
 *           7   8   9
 *   output: 1, 2, 4, 7, 5, 3, 6, 8, 9
 * </pre>
 * <p>
 * 思路: 定义一个变量rightUp，当rightUp=true时表示往右上移动，rightUp=false表示往左下移动。
 * <p>
 * 当rightUp=true往右上移动时，分为两种情况：
 * <p>
 * 第一: 当触发了rowIndex=0或columnIndex = Max时，需要换方向rightUp=false。
 * <pre>
 *   1.1 columnIndex = Max，下次起点就是rowIndex = rowIndex + 1, columnIndex = Max
 *   1.2 rowIndex = 0，下次起点就是rowIndex = 0, columnIndex = columnIndex+1
 * </pre>
 * 第二: 未触发了rowIndex=0或columnIndex = Max时，则rowIndex=rowIndex-1, columnIndex=columnInde+1
 * <p>
 * 当rightUp=false往左下移动时，类似。
 * <p>
 * 类似题型: Decode the Slanted Ciphertext
 *
 * @author vlin 2022/1/9
 */
public class Leetcode498 {

  /**
   * faster than 48.32%，less than 16.34%
   */
  public int[] findDiagonalOrder(int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    int index = 0;
    int[] result = new int[m * n];
    boolean rightUp = true;
    int row = 0;
    int column = 0;
    while (index < m * n) {
      if (rightUp) {
        if (row == 0 || column == n - 1) {
          rightUp = false;
          result[index++] = mat[row][column];
          if (column == n - 1) {
            row = row + 1;
            column = column;
          } else {
            row = row;
            column = column + 1;
          }
        } else {
          result[index++] = mat[row][column];
          row = row - 1;
          column = column + 1;
        }
      } else {
        if (column == 0 || row == m - 1) {
          rightUp = true;
          result[index++] = mat[row][column];
          if (row == m - 1) {
            row = row;
            column = column + 1;
          } else {
            row = row + 1;
            column = column;
          }
        } else {
          result[index++] = mat[row][column];
          row = row + 1;
          column = column - 1;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    // Output 1,2,4,7,5,3,6,8,9
    int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    // Output 1,2,3,4
//    int[][] mat = {{1, 2}, {3, 4}};

    Leetcode498 leetcode498 = new Leetcode498();
    ConsoleOutput.printf(leetcode498.findDiagonalOrder(mat));
  }
}
