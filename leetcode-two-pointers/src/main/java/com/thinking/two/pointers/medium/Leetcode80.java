package com.thinking.two.pointers.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Remove Duplicated form Sorted Array II
 * <p>
 * 题目: 给定一个已经排序的数组nums，去除掉多余的数字，每个数字最多保留两个。要求空间复杂度为O(1)
 * <p>
 * 思路1(推荐): 由于最多可以保留两个相同的数字，使用双指针，第一个指针result=2开始，用于纪录结果的。第二指针pos来遍历数组
 * <p>
 * 每次nums[pos] == nums[result-1] && nums[result-2]时，则nums[pos]表示可以丢弃。
 * <p>
 * 思路2:这个是我自己想的方法。思路是当数组nums判断nums[i]==nums[i+1]时，说明可能有需要丢弃的数字，通过while循环
 * <p>
 * 往后续遍历，将后续相同的数字丢弃。
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

  /**
   * 推荐解法。
   */
  public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) {
      return nums.length;
    }
    int result = 2;
    for (int i = 2; i < nums.length; i++) {
      if (nums[i] == nums[result - 1] && nums[result - 1] == nums[result - 2]) {
        continue;
      } else {
        nums[result++] = nums[i];
      }
    }
    return result;
  }

  public int removeDuplicates2(int[] nums) {
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

  public static void main(String[] args) {
    // Output 5, nums=[1, 1, 2, 2, 3]
    int[] nums = {1, 1, 1, 2, 2, 3};
    // Output 7 nums=[0, 0, 1, 1, 2, 3, 3]
//    int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
    Leetcode80 leetcode80 = new Leetcode80();
    ConsoleOutput.printf(leetcode80.removeDuplicates(nums));
    ConsoleOutput.printf(nums);
  }
}
