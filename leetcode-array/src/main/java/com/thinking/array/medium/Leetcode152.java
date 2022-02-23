package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Maximum Product Subarray
 * <p>
 * 题目: 给定一个数组nums，数组中有负数和整数，求数组中子数组的乘积最大值
 * <p>
 * 思路：
 * <p>
 * 类似题型：
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
    // Output 6
//    int[] nums = {2, -3, 2, 4};

    // Output 0
    int[] nums = {3, -1, 4};

    Leetcode152 leetcode152 = new Leetcode152();
    ConsoleOutput.printf(leetcode152.maxProduct(nums));
  }
}
