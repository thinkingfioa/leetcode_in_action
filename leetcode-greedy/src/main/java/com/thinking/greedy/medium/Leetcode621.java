package com.thinking.greedy.medium;

import com.thinking.common.ConsoleOutput;
import java.util.Arrays;

/**
 * Title: Task Scheduler
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/7/11
 */
public class Leetcode621 {

  /**
   * faster than 99.51%, less than 57.22%
   */
  public int leastInterval(char[] tasks, int n) {
    int[] letterArray = new int[26];
    for (char task : tasks) {
      letterArray[task - 'A']++;
    }
    Arrays.sort(letterArray);
    int needIdea = (letterArray[25] - 1) * n;
    for (int move = 24; move >= 0 && letterArray[move] > 0; move--) {
      needIdea -= Math.min(letterArray[25] - 1, letterArray[move]);
    }
    if (needIdea > 0) {
      return tasks.length + needIdea;
    } else {
      return tasks.length;
    }
  }

  public static void main(String[] args) {
    // output 8
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//    char[] tasks = {'A', 'A', 'A', 'B', 'B'};
    int n = 2;
    Leetcode621 leetcode621 = new Leetcode621();
    ConsoleOutput.printf(leetcode621.leastInterval(tasks, n));
  }
}
