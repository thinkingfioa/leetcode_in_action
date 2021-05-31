package com.thinking.graph.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Number of Islands
 * <p>
 * 题目: 给一个二维矩阵grid，grid[i][j]='1'代表陆地，grid[i][j]='0'代表海洋。求grid[i][j]中岛屿的数量。
 * <p>
 * 思路:
 * <p>
 * 类似题型: Surrounded Regions
 * <p>
 * Walls and Gates
 * <p>
 * Number of Islands II
 * <p>
 * Number of Connected Components in an Undirected Graph
 * <p>
 * Number of Distinct Islands
 * <p>
 * Max Area of Island
 *
 * @author thinking_fioa 2021/5/29
 */
public class Leetcode200 {

  private static final char ISLAND = '1';
  private static final char WATER = '0';

  /**
   * faster than 45.03%, less than 28.28%
   */
  public int numIslands(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int row = grid.length;
    int column = grid[0].length;

    int[][] visited = new int[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (grid[i][j] == ISLAND) {
          visited[i][j] = 1;
        } else {
          visited[i][j] = 0;
        }
      }
    }
    // 遍历
    int result = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (grid[i][j] == ISLAND && visited[i][j] == 1) {
          dfsFind(grid, visited, i, row, j, column);
          result++;
        }
      }
    }

    return result;
  }

  private void dfsFind(char[][] grid, int[][] visited, int rowIndex, int row,
      int columnIndex, int column) {
    if (rowIndex >= row || rowIndex < 0 || columnIndex >= column || columnIndex < 0) {
      return;
    }
    if (grid[rowIndex][columnIndex] == WATER || visited[rowIndex][columnIndex] == 0) {
      return;
    }
    visited[rowIndex][columnIndex] = 0;
    dfsFind(grid, visited, rowIndex + 1, row, columnIndex, column);
    dfsFind(grid, visited, rowIndex - 1, row, columnIndex, column);
    dfsFind(grid, visited, rowIndex, row, columnIndex + 1, column);
    dfsFind(grid, visited, rowIndex, row, columnIndex - 1, column);
  }

  public static void main(String[] args) {
    // output 1
//    char[][] grid = {{'1', '1', '1', '1', '0'},
//        {'1', '1', '0', '1', '0'},
//        {'1', '1', '0', '0', '0'},
//        {'0', '0', '0', '0', '0'}};
    // output 3
    char[][] grid = {{'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}};

    Leetcode200 leetcode200 = new Leetcode200();
    int num = leetcode200.numIslands(grid);
    ConsoleOutput.printf(num);
  }
}
