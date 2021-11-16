package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: First Missing Positive
 * <p>
 * 题目: 给定一个无序的数组nums[]，找到数组中第一个未出现的正整数，题目最终的要求是O(n)和常量的空间
 * <pre>
 *   input     3,4,-1,1
 *   output    2
 * </pre>
 * <p>
 * 思路1: 假设允许开辟一个新的空间数组positiveNums[]，我们可以将无序数组nums[]中每个元素取出nums[i]，
 * <p>
 * 作为放到数组positiveNums[nums[i]-1]的位置上。完成后遍历positiveNums[]第一个不存在的即可。
 * <p>
 * 但题目要求是使用常量空间，意味着不允许新开辟数组。
 * <p>
 * 但我们可以思考是不是可以在原数组中做，遍历nums[]数组时，发现nums[i]<length,交换nums[nums[i]-1]和nums[i]的值，再重复检查nums[i]。
 * <p>
 * 提醒：要特殊处理nums[nums[i]-1]==nums[i]的场景，避免死循环
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
