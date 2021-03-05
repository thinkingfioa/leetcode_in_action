package com.thinking.medium;

import com.thinking.ConsoleOutput;

/**
 * Title:
 * <p>
 * 题目:
 * <p>
 * 思路1:
 * <p>
 * 思路2:
 * <p>
 * 类似题型: 852 Peak Index in a Mountain Array
 *
 * @author thinking_fioa 2021/3/5
 */
public class Leetcode162 {

  public int findPeakElement(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    return binarySearch(nums, 0, nums.length - 1);
  }

  private int binarySearch(int[] nums, int left, int right) {
    int mid = (left + right) / 2;

    if (mid == left) {
      // find
      if (nums[left] > nums[right] && (left == 0 || nums[left] > nums[left - 1])) {
        return left;
      } else if (nums[left] < nums[right] && (right == nums.length - 1
          || nums[right] > nums[right + 1])) {
        return right;
      } else {
        return -1;
      }
    }

    int result = binarySearch(nums, left, mid);
    if (result >= 0) {
      return result;
    }
    return binarySearch(nums, mid, right);
  }

  public static void main(String[] args) {
//    int[] nums = {1, 2, 3, 1};
    int[] nums = {1, 2, 1, 3, 5, 6, 4};
    Leetcode162 leetcode162 = new Leetcode162();
    ConsoleOutput.printf(leetcode162.findPeakElement(nums));
  }
}
