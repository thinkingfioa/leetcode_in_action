package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Trapping Rain Water
 * <p>
 * 题目: 给定一个数字数组nums，每个元素都是正整数。nums[i]表示方块的高度，问：如果数组nums的所有方块按照顺序排列，下雨时
 * <p>
 * 能积累多少个方块雨水。
 * <p>
 * 思路: 其实题目本意是想求出凹进去的方块数目。假设遍历到nums[i]，我们不知道后面是否有nums[j]>nums[i](j >i)，
 * <p>
 * 如果有，那么数组nums在区间[i, j]之间就能积累雨水。
 * <p>
 * 我们比较好处理nums[i] < nums[j]的场景，试想我们分别从left -> right和right -> left计算依次，找到递增的两个数
 * <p>
 * 两个数之间就是能存的水滴数。
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
    // 2
    int[] height = {2, 0, 2};
    Leetcode42 leetcode42 = new Leetcode42();
    ConsoleOutput.printf(leetcode42.trap(height));
  }
}
