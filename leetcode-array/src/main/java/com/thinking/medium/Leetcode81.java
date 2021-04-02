package com.thinking.medium;

import com.thinking.ConsoleOutput;

/**
 * Title: Search in Rotated Sorted Array II
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:  Search in Rotated Sorted Array
 * <p>
 * Find the Duplicate Number
 * <p>
 * Previous Permutation With One Swap
 * <p>
 * Decompress Run-Length Encoded List
 *
 * @author thinking_fioa 2021/4/2
 */
public class Leetcode81 {

  public boolean search(int[] nums, int target) {
    return find(nums, target, 0, nums.length - 1);
  }

  private boolean find(int[] nums, int target, int left, int right) {
    int mid = (left + right) / 2;
    if (nums[mid] == target) {
      return true;
    }
    if (left >= right) {
      return false;
    }

    if (nums[left] < nums[mid]) {
      // left is sorted
      if (nums[mid] > target && find(nums, target, left, mid - 1)) {
        return true;
      } else {
        return find(nums, target, mid + 1, right);
      }
    } else if (nums[left] > nums[mid]) {
      // right is sorted
      if (nums[mid] < target && find(nums, target, mid + 1, right)) {
        return true;
      } else {
        return find(nums, target, left, mid - 1);
      }
    } else {
      if (find(nums, target, left + 1, mid - 1)) {
        return true;
      }
      return find(nums, target, mid + 1, right);
    }
  }

  public static void main(String[] args) {
    // Output true
//    int[] nums = {2, 5, 6, 0, 0, 1, 2};
//    int target = 0;
    // Output false
//    int[] nums = {2, 5, 6, 0, 0, 1, 2};
//    int target = 3;
    // Output true
    int[] nums = {1, 0, 1, 1, 1, 1, 1, 1};
    int target = 0;
    Leetcode81 leetcode81 = new Leetcode81();
    ConsoleOutput.printf(leetcode81.search(nums, target));
  }
}
