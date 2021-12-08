package com.thinking.dfs.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Max Area of Island
 * <p>
 * 题目: 给定一个二维数组grid[][]，数组中的元素都是由1或0组成。1代表是陆地，0代表是水。
 * <p>
 * 假设二维数组grid[][]四周都是由水包围着，问二维数组grid[][]中，岛屿中最大的陆地数
 * <pre>
 *     输入： {1, 1, 0, 0, 0}
 *           {1, 1, 0, 0, 0}
 *           {0, 0, 0, 1, 1}
 *           {0, 0, 0, 1, 1}
 *     输出：4
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 类似题型: Island Perimeter
 * <p>
 * Largest Submatrix With Rearrangements
 *
 * @author vlin 2021/12/7
 */
public class Leetcode695 {

  /**
   * faster than 99.33%，less than 45.48%
   */
  public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int[][] visited = new int[m][n];

    int maxArea = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 0 && grid[i][j] == 1) {
          maxArea = Math.max(maxArea, dfs(grid, visited, i, m, j, n, 1) - 1);
        }
      }
    }
    return maxArea;
  }

  private int dfs(int[][] grid, int[][] visited, int row, int m, int column, int n, int num) {
    if (num == 0) {
      return 0;
    }
    if (row < 0 || column < 0 || row >= m || column >= n) {
      return num;
    }
    if (visited[row][column] == 1) {
      return num;
    }
    // mark visited
    visited[row][column] = 1;
    if (grid[row][column] == 0) {
      return num;
    }
    num++;
    // top
    num = dfs(grid, visited, row - 1, m, column, n, num);
    // right
    num = dfs(grid, visited, row, m, column + 1, n, num);
    // down
    num = dfs(grid, visited, row + 1, m, column, n, num);
    // left
    num = dfs(grid, visited, row, m, column - 1, n, num);
    return num;
  }

  public static void main(String[] args) {
    // Output 6
    int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};

    // Output 4
//    int[][] grid = {{1, 1, 0, 0, 0},
//        {1, 1, 0, 0, 0},
//        {0, 0, 0, 1, 1},
//        {0, 0, 0, 1, 1}};

    Leetcode695 leetcode695 = new Leetcode695();
    ConsoleOutput.printf(leetcode695.maxAreaOfIsland(grid));
  }
}
