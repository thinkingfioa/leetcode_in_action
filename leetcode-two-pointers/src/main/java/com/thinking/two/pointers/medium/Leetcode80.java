package com.thinking.two.pointers.medium;

import com.thinking.ConsoleOutput;

/**
 * Title: Remove Duplicated form Sorted Array II
 * <p>
 * 题目:
 * <p>
 * 思路1:
 * <p>
 * 思路2:
 * <p>
 * 类似题型: Median of Two Sorted Arrays
 * <p>
 * Largest Rectangle in Histogram
 * <p>
 * Find the Duplicate Number
 *
 * @author thinking_fioa 2021/4/14
 */
public class Leetcode80 {

  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int result = 0;
    int i = 0;
    for (; i + 1 < nums.length; i++) {
      if (nums[i] == nums[i + 1]) {
        nums[result++] = nums[i];
        nums[result++] = nums[i + 1];
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
          i++;
        }
      } else {
        nums[result++] = nums[i];
      }
    }
    if (i < nums.length && nums[i - 1] != nums[i]) {
      nums[result++] = nums[i];
    }
    return result;
  }

  public int removeDuplicates2(int[] nums) {
    // TODO 思路2 by thinking_fioa
    return -1;
  }

  public static void main(String[] args) {
    // Output 5, nums=[1, 1, 2, 2, 3]
//    int[] nums = {1, 1, 1, 2, 2, 3};
    // Output 7 nums=[0, 0, 1, 1, 2, 3, 3]
    int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    Leetcode80 leetcode80 = new Leetcode80();
    ConsoleOutput.printf(leetcode80.removeDuplicates(nums));
    ConsoleOutput.printf(nums);
  }
}
