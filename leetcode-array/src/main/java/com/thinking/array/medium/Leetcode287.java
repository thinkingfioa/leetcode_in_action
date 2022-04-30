package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Find the Duplicate Number
 * <p>
 * 题目: 给定一个数组nums，包含n+1个元素，每个元素在[1, n]个范围内选择，数组中只会有一个重复的数组，请找出这个数字。不允许
 * <p>
 * 移动数组元素的位置且空间复杂度为O(1)
 * <pre>
 *  Input ：1, 3, 4, 2, 2
 *  Output：2
 *
 *  Input: 2，2，2，2，2
 *  Output: 2
 * </pre>
 * <p>
 * 思路1: 二分法
 * <p>
 * 思路2：快慢指针
 * <p>
 * 类似题型: Single Number
 * <p>
 * Missing Number
 * <p>
 * Set Mismatch
 *
 * @author vlin 2022/4/24
 */
public class Leetcode287 {

  /**
   * 二分法：faster than 31.38%，less than 21.24%
   */
  public int findDuplicate(int[] nums) {
    int left = 1;
    int right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      // 计算小于等于mid的数字个数
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= mid) {
          count++;
        }
      }
      if (count <= mid) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return right;
  }


  public static void main(String[] args) {
    // Outut 3
//    int[] nums = {3, 1, 3, 4, 2};
    int[] nums = {2, 2, 2, 2, 2};
    Leetcode287 leetcode287 = new Leetcode287();
    ConsoleOutput.printf(leetcode287.findDuplicate(nums));
  }
}
