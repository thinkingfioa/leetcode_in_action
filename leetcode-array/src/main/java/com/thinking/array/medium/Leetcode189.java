package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Rotate Array
 * <p>
 * 题目：给一个数组nums和一个非负数字k，循转数组nums前k位
 * <pre>
 *   input:   nums = [1,2,3,4,5,6,7], k = 3
 *   output:  [5,6,7,1,2,3,4]
 * </pre>
 * <p>
 * 思路：有一个方法，根据给定的非负数k，可以将原数组nums切分成两个子数组[0, len-k)和[len-k, len)
 * <p>
 * 第一步：先将两个子数组各自旋转一次
 * <p>
 * 第二步：再将两个子数组旋转后组成的数组再循转一次
 * <p>
 * 类似题型：Reverse Words in a String II
 *
 * @author vlin 2022/3/27
 */
public class Leetcode189 {

  /**
   * faster than 81.72%，less than 90.39%
   */
  public void rotate(int[] nums, int k) {
    if (k == 0) {
      return;
    }

    k = k % nums.length;
    swap(nums, 0, nums.length - k - 1);
    swap(nums, nums.length - k, nums.length - 1);
    swap(nums, 0, nums.length - 1);
  }

  private void swap(int[] nums, int begin, int end) {
    while (begin < end) {
      int tmp = nums[begin];
      nums[begin] = nums[end];
      nums[end] = tmp;
      begin++;
      end--;
    }
  }

  public static void main(String[] args) {
    // Output [5, 6, 7, 1, 2, 3, 4]
    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;

    Leetcode189 leetcode189 = new Leetcode189();
    leetcode189.rotate(nums, k);
    ConsoleOutput.printf(nums);
  }
}
