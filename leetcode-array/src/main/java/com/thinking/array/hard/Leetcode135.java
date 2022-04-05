package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Candy
 * <p>
 * 题目: 给定n个小孩，每个孩子有一个速度值，组成ratings[]数组，要求给孩子发糖果，求出发最小的糖果数目
 * <p>
 * 需要满足以下两个条件：
 * <pre>
 *   第一：每个孩子都有一个糖果
 *   第二：如果速度值比旁边的孩子大，则糖果数也要大一点
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 类似题型: K Empty Slots
 * <p>
 * Find and Replace in String
 * <p>
 * Maximum Profit of Operating a Centennial Wheel
 *
 * @author vlin 2022/4/3
 */
public class Leetcode135 {

  /**
   * faster than 68.24%，less than 58.96%
   */
  public int candy(int[] ratings) {
    int result = 0;
    int[] candyArray = new int[ratings.length];
    for (int i = 0; i < ratings.length; i++) {
      candyArray[i] = 1;
    }
    for (int i = 1; i < ratings.length; i++) {
      if (ratings[i] > ratings[i - 1]) {
        candyArray[i] = Math.max(candyArray[i - 1] + 1, candyArray[i]);
      }
    }
    for (int i = ratings.length - 1; i > 0; i--) {
      if (ratings[i] < ratings[i - 1]) {
        candyArray[i - 1] = Math.max(candyArray[i] + 1, candyArray[i - 1]);
      }
    }
//    ConsoleOutput.printf(candyArray);
    for (int i = 0; i < candyArray.length; i++) {
      result += candyArray[i];
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 4
//    int[] ratings = {1, 2, 2};

    // Output 15
    int[] ratings = {1, 5, 7, 6, 3, 4, 8, 1};

    Leetcode135 leetcode135 = new Leetcode135();
    ConsoleOutput.printf(leetcode135.candy(ratings));
  }
}
