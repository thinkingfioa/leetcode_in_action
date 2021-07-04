package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Corporate Flight Bookings
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: H-Index II
 * <p>
 * Best Time to Buy and Sell Stock with Transaction Fee
 * <p>
 * Subarray Sums Divisible by K
 *
 * @author thinking_fioa 2021/7/4
 */
public class Leetcode1109 {

  /**
   * faster than 41.11%，less than 43.01%
   */
  public int[] corpFlightBookings(int[][] bookings, int n) {
    int[] result = new int[n];
    for (int i = 0; i < bookings.length; i++) {
      int first = bookings[i][0] - 1;
      int last = bookings[i][1] - 1;
      int seat = bookings[i][2];
      for (int j = first; j <= last; j++) {
        result[j] += seat;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Leetcode1109 leetcode1109 = new Leetcode1109();
    // [10,55,45,25,25]
    int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
    int n = 5;
    ConsoleOutput.printf(leetcode1109.corpFlightBookings(bookings, n));
  }
}
