package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: First Missing Positive
 * <p>
 * 题目: 给定一个无序的数组nums[]，找到数组中第一个未出现的正整数
 * <pre>
 *   input     3,4,-1,1
 *   output    2
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 思路2：比较简单的想法是，先对数组排序，然后再找第一个未出现的正整数。但题目最终的要求是O(n)和常量的空间
 * <p>
 * 类似题型: Missing Number
 * <p>
 * Find the duplicate Number
 * <p>
 * Find All Numbers Disappeared in an Array
 * <p>
 * Couples Holding Hands
 *
 * @author vlin 2021/11/9
 */
public class Leetcode41 {

  /**
   * faster than 99.01%，less than 53.96%
   */
  public int firstMissingPositive(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      while (nums[i] != i + 1 && nums[i] >= 1 && nums[i] <= nums.length) {
        if (nums[nums[i] - 1] != nums[i]) {
          swap(nums, nums[i] - 1, i);
        } else {
          break;
        }
      }
    }

    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != i + 1) {
        return i + 1;
      }
    }
    return nums.length + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  public static void main(String[] args) {
    // Output 2
    int[] nums = {1};

    // Output 2
//    int[] nums = {3, 3, 4, -1, 1};

    Leetcode41 leetcode41 = new Leetcode41();
    ConsoleOutput.printf(leetcode41.firstMissingPositive(nums));
  }
}
