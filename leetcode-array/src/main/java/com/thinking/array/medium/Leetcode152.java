package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Maximum Product Subarray
 * <p>
 * 题目: 给定一个数组nums，数组中有负数、整数和0，求数组中子数组的乘积最大值
 * <pre>
 *     input:  {2, -3, 2, 4};
 *     output: 8
 *   </pre>
 * 思路：子数组成乘积最大，假设我们先不考虑数值0，如果数组中所有元素为正数或偶数个负数，那么最大乘积就是所有元素
 * <p>
 * 如果数组元素存在奇数个负数，那么最大乘积要不是从第一个负数后一位开始所有元素组成最大乘积，要么是不包括最后一个负数后
 * <p>
 * 的所有元素组成的最大乘积
 * <p>
 * 类似题型：Product of Array Except Self
 * <p>
 * Maximum Product of Three Numbers
 * <p>
 * Subarray Product Less Than K
 *
 * @author vlin 2022/2/21
 */
public class Leetcode152 {

  /**
   * faster than 96.72%, less than 44.18%
   */
  public int maxProduct(int[] nums) {
    if (nums.length == 1 && nums[0] < 0) {
      return nums[0];
    }
    int result = 0;
    int left = -1;
    int tmpResult = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        left++;
        while (tmpResult < 0 && left < i - 1) {
          tmpResult /= nums[left++];
        }
        result = Math.max(result, tmpResult);
        left = i;
        tmpResult = 0;
        continue;
      }
      tmpResult = tmpResult == 0 ? nums[i] : tmpResult * nums[i];
      result = Math.max(result, tmpResult);
    }

    left++;
    while (tmpResult < 0 && left < nums.length - 1) {
      tmpResult /= nums[left++];
    }
    result = Math.max(result, tmpResult);
    return result;
  }

  public static void main(String[] args) {
    // Output 8
//    int[] nums = {2, -3, 2, 4};

    // Output 4
    int[] nums = {3, -1, 4};

    Leetcode152 leetcode152 = new Leetcode152();
    ConsoleOutput.printf(leetcode152.maxProduct(nums));
  }
}
