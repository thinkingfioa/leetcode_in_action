package com.thinking.array.easy;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Maximum Average Subarray I
 * <p>
 * 题目: 给定一个数字数组nums，和一个整数k，数组中连续k个元素最大平均值。
 * <p>
 * 思路: 类似这种连续k个元素求和，第一想到的是构建一个sumArray数组，sumArray[i]表示前i个元素的和
 * <p>
 * 后期我们根据计算平均值可直接(sumArray[i+k]-sumArray[i])/k，即可得出最大平均值
 * <p>
 * 类似题型: Maximum Average Subarray II
 *
 * @author thinking_fioa 2021/7/22
 */
public class Leetcode643 {

  /**
   * faster than 42.52%, less than 98.24%
   */
  public double findMaxAverage(int[] nums, int k) {
    int[] sumArray = new int[nums.length + 1];
    int sum = 0;
    sumArray[0] = sum;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      sumArray[i + 1] = sum;
    }
    double result = Double.MIN_EXPONENT;
    for (int begin = 0; begin + k < sumArray.length; begin++) {
      double avg = (sumArray[begin + k] - sumArray[begin]) / (double) k;
      result = Math.max(avg, result);
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 12.75000
    int[] nums = {1, 12, -5, -6, 50, 3};
    int k = 4;
    Leetcode643 leetcode643 = new Leetcode643();
    ConsoleOutput.printf(leetcode643.findMaxAverage(nums, k));
  }
}
