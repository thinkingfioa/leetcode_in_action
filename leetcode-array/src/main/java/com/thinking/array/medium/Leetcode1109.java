package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Corporate Flight Bookings
 * <p>
 * 题目: 给一个二维数组bookings，每行有三个元素，分别是(fist, last, seat)代表航班[fist, last]之间每个航班买seat个座位。
 * <p>
 * 求：每个飞机航班共卖出总座位数目
 * <p>
 * 思路: 建立一个结果数组result[]，数组下标代表的是航班，result[i]表示第i个航班卖出的座位数。遍历二维数组bookings，依次填值。
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
