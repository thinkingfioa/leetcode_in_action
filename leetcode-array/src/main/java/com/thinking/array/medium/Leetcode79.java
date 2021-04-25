package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: WordSearch
 * <p>
 * 题目: 给定一个二维数组board[][]，存放着小写和大写字母。再给定一个字符串word，
 * <p>
 * 判断字符串word是否在二维数组board[][]中通过上下左右组装起来，每个元素只能使用一次
 *
 * <p>
 * 相同题目：212 Word Search II
 * <p>
 * 思路：使用DFS搜索算法，最外层循环判断二维数组board[][]每个元素是否与word[0][0]相同，
 * <p>
 * 如果相同，则开始DFS分别从上下左右查找。
 *
 * @author thinking_fioa 2021/3/3
 */
public class Leetcode79 {

  private static final char VISITED = '0';

  public boolean exist(char[][] board, String word) {
    int rowNum = board.length;
    int columnNum = rowNum > 0 ? board[0].length : 0;
    for (int rowIndex = 0; rowIndex < rowNum; rowIndex++) {
      for (int columnIndex = 0; columnIndex < columnNum; columnIndex++) {
        if (dfs(board, rowNum, columnNum, rowIndex, columnIndex, word, 0)) {
          return true;
        }
      }
    }
    return false;
  }


  private boolean dfs(char[][] board, int rowNum, int columnNum, int rowIndex, int columnIndex,
      String word, int wordIndex) {
    if (wordIndex >= word.length()) {
      return true;
    }
    char singleChar = word.charAt(wordIndex);
    if (!legalIndex(rowIndex, rowNum) || !legalIndex(columnIndex, columnNum)) {
      return false;
    }
    if (board[rowIndex][columnIndex] != singleChar) {
      return false;
    }
    // deep find
    board[rowIndex][columnIndex] = VISITED;
    // to up
    if (dfs(board, rowNum, columnNum, rowIndex - 1, columnIndex, word, wordIndex + 1)) {
      board[rowIndex][columnIndex] = singleChar;
      return true;
    }
    // to left
    if (dfs(board, rowNum, columnNum, rowIndex, columnIndex - 1, word, wordIndex + 1)) {
      board[rowIndex][columnIndex] = singleChar;
      return true;
    }
    // to right
    if (dfs(board, rowNum, columnNum, rowIndex, columnIndex + 1, word, wordIndex + 1)) {
      board[rowIndex][columnIndex] = singleChar;
      return true;
    }
    // to down
    if (dfs(board, rowNum, columnNum, rowIndex + 1, columnIndex, word, wordIndex + 1)) {
      board[rowIndex][columnIndex] = singleChar;
      return true;
    }
    board[rowIndex][columnIndex] = singleChar;
    return false;
  }

  private boolean legalIndex(int index, int num) {
    return index >= 0 && index < num;
  }

  public static void main(String[] args) {
    char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
    String word = "ABCCED";
    Leetcode79 leetcode79 = new Leetcode79();
    boolean result = leetcode79.exist(board, word);
    ConsoleOutput.printf(result);
  }
}
