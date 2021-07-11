package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Shortest Subarray with Sum at Least K
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Minimum Index Sum of Two Lists
 * <p>
 * Maximum Sum Obtained of Any Permutation
 * <p>
 * Widest Vertical Area Between Two Points Containing No Points
 *
 * @author thinking_fioa 2021/7/11
 */
public class Leetcode862 {

  /**
   * faster than 45.58%，less than 67.81%
   */
  public int shortestSubarray(int[] nums, int k) {
    int[] sumArray = new int[nums.length + 1];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      sumArray[i + 1] = sum;
    }
    int result = Integer.MAX_VALUE;
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    for (int i = 1; i < sumArray.length; i++) {
      while (!queue.isEmpty() && (sumArray[i] - sumArray[queue.getFirst()]) >= k) {
        result = Math.min(i - queue.getFirst(), result);
        queue.removeFirst();
      }
      while (!queue.isEmpty() && (sumArray[i] <= sumArray[queue.getLast()])) {
        queue.removeLast();
      }
      queue.add(i);
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public static void main(String[] args) {
    // Output 3
//    int[] nums = {2, -1, 2};
//    int k = 3;
    // Output 1
    int[] nums = {77, 19, 35, 10, -14};
    int k = 19;
    Leetcode862 leetcode862 = new Leetcode862();
    ConsoleOutput.printf(leetcode862.shortestSubarray(nums, k));
  }
}
