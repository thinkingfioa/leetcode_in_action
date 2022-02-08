package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Minimum Size Subarray Sum
 * <p>
 * 题目: 给定一个全部都是正整数的数组nums[]和一个正整数target。求数组nums[]最少的子数组和大于等于target，
 * <p>
 * 输出该子数组的元素长度
 *
 * <pre>
 *   input:  target = 7, nums= {1, 2, 3, 4, 5}
 *   output: 3，因为subNum= {3, 4, 5}
 * </pre>
 * <p>
 * 思路：
 * <p>
 * 类似题型：Maximum Size Subarray Sum Equals k
 * <p>
 * Minimum Operations to Reduce X to Zero
 * <p>
 * K Radius Subarray Averages
 *
 * @author vlin 2022/2/8
 */
public class Leetcode209 {

  /**
   * faster than 99.96%, less than 5.67%
   */
  public int minSubArrayLen(int target, int[] nums) {
    int tmpSum = 0;
    int left = -1;
    int result = nums.length + 1;
    for (int i = 0; i < nums.length; i++) {
      tmpSum += nums[i];
      if (tmpSum >= target) {
        result = Math.min(result, i - left);
      }
      if (tmpSum > target) {
        while (tmpSum >= target && left < i) {
          result = Math.min(result, i - left);
          left++;
          tmpSum -= nums[left];
        }
      }
    }

    return result == nums.length + 1 ? 0 : result;
  }

  public static void main(String[] args) {
    // Output 2
//    int target = 7;
//    int[] nums = {2, 3, 1, 2, 4, 3};

    // Output 3
    int target = 11;
    int[] nums = {1, 2, 3, 4, 5};

    Leetcode209 leetcode209 = new Leetcode209();
    ConsoleOutput.printf(leetcode209.minSubArrayLen(target, nums));
  }
}
