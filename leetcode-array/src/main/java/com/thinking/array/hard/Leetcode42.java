package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Trapping Rain Water
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Product of Array Except Self
 * <p>
 * Trapping Rain Water II
 * <p>
 * Pour Water
 *
 * @author thinking_fioa 2021/6/5
 */
public class Leetcode42 {

  /**
   * faster than 100.00%, less than 95.46%
   */
  public int trap(int[] height) {
    if (height.length <= 1) {
      return 0;
    }
    int result = 0;
    // left to right
    int begin = height[0];
    int beginIndex = 0;
    int tmpRain = 0;
    for (int i = 1; i < height.length; i++) {
      if (height[i] >= begin) {
        result += (i - beginIndex - 1) * begin - tmpRain;
        begin = height[i];
        beginIndex = i;
        tmpRain = 0;
      } else {
        tmpRain += height[i];
      }
    }
    // right to left
    begin = height[height.length - 1];
    beginIndex = height.length - 1;
    tmpRain = 0;
    for (int i = height.length - 2; i >= 0; i--) {
      if (height[i] > begin) {
        result += (beginIndex - i - 1) * begin - tmpRain;
        begin = height[i];
        beginIndex = i;
        tmpRain = 0;
      } else {
        tmpRain += height[i];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // 6
//    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    // 9
//    int[] height = {4, 2, 0, 3, 2, 5};
    //
    int[] height = {2, 0, 2};
    Leetcode42 leetcode42 = new Leetcode42();
    ConsoleOutput.printf(leetcode42.trap(height));
  }
}
