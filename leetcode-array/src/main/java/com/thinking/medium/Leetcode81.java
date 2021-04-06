package com.thinking.medium;

import com.thinking.ConsoleOutput;

/**
 * Title: Search in Rotated Sorted Array II
 * <p>
 * 题目: 给定一个旋转数组nums和目标target，问：判断target是否在旋转数组nums中。循转数组：数组nums从某个下标i开始，[i+1, n-1]是递增的序列，[0,
 * i]是递减序列，则成为nums按照第i下标进行了旋转。 注意：数组中会有重复相等的数字
 * <p>
 * 思路: 题目思路采用的是二分法的变形。 题目突破口在于[left, right]区间， 取中点mid=(left+right)/2后，
 * <p>
 * 分为两个区间A=[left, mid)和B=(mid, right]，A和B区间肯定有一个是连续的，优先判断target是否在连续的区间内，如果不再，肯定就在不连续的区间内。
 * <p>
 * 提醒：由于数组nums中有重复的相等数组，所以上诉思路无法解决nums=[1, 0, 1, 1, 1, 1, 1, 1]和target=0，该输入需要特殊处理
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
