package com.thinking.heap.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Kth Largest Element in an Array
 * <p>
 * 题目:
 * <p>
 * 思路: 基于快速排序的思路来找第K个大的元素。
 * <p>
 * 类似题型: Wiggle Sort II
 * <p>
 * Top K Frequent Elements
 * <p>
 * Third Maximum Number
 * <p>
 * Kth Largest Element in a Stream
 * <p>
 * K Close Points to Origin
 *
 * @author thinking_fioa 2021/4/24
 */
public class Leetcode215 {

  public int findKthLargest(int[] nums, int k) {
    int pos = findKth(nums, 0, nums.length - 1, k);
    return nums[pos];
  }

  public int findKth(int[] nums, int left, int right, int k) {
    int pos = findQuickSearch(nums, left, right);
    if (pos == nums.length - k) {
      return pos;
    } else if (pos > nums.length - k) {
      return findKth(nums, left, pos - 1, k);
    } else {
      return findKth(nums, pos + 1, right, k);
    }
  }

  public int findQuickSearch(int[] nums, int left, int right) {
    int tmpValue = nums[left];
    while (left < right) {
      while (left < right && nums[right] >= tmpValue) {
        right--;
      }
      nums[left] = nums[right];
      while (left < right && nums[left] < tmpValue) {
        left++;
      }
      nums[right] = nums[left];
    }
    nums[left] = tmpValue;
    return left;
  }

  public static void main(String[] args) {
    //  Output 5
//    int[] nums = {3, 2, 1, 5, 6, 4};
//    int k = 2;
    // Output 4
    int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
    int k = 4;
    Leetcode215 leetcode215 = new Leetcode215();
    ConsoleOutput.printf(leetcode215.findKthLargest(nums, k));
  }
}
