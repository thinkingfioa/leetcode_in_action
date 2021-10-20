package com.thinking.sort.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Course Schedule II
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/10/20
 */
public class Leetcode210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    return new int[0];
  }

  public static void main(String[] args) {
    // Output 0, 2, 1, 3 or 0, 1, 2, 3
//    int numCourses = 4;
//    int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}};

    // Output [0]
    int numCourses = 2;
    int[][] prerequisites = {{1, 0}};

    Leetcode210 leetcode210 = new Leetcode210();
    ConsoleOutput.printf(leetcode210.findOrder(numCourses, prerequisites));
  }
}
