package com.thinking.binary.search.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Find Peak Element
 * <p>
 * 题目: 给定一个数组nums[]，在数组中找到一个元素 nums[i-1] < nums[i] > nums[i+1]，我们认为nums[i]为peak的元素。 同时定义nums[-1] =
 * nums[n] = -∞。
 * <p>
 * 思路1: 最简单的方法是，遍历一遍，每个元素判断一次。时间复杂度是O(n)
 * <p>
 * 思路2: 采用二分查找方法，当left=mid时，判断是否当前的nums[mid]符合要求，否则二分查找[left, mid]进入左分支，出来后再[mid, right]进入右分支查找
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
    int[] nums = {1, 2, 1, 3, 5, 6, 4};
    Leetcode162 leetcode162 = new Leetcode162();
    ConsoleOutput.printf(leetcode162.findPeakElement(nums));
  }
}
