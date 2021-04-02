package com.thinking.greedy.medium;

import com.thinking.ConsoleOutput;

/**
 * Title: Wiggle Subsequence
 * <p>
 * 题目: 给定一串数字的数组nums[]，要求从数组中找到子序列使其满足: Wiggle Subsequence，输出子序列的长度。
 * <p>
 * Wiggle Subsequence要求每两个相邻的数相减得到的结果数组result[]，结果数组result[]中元素满足正负交替
 * <p>
 * 思路: 题目的意思转换以下：求数组中nums[]的数字大小转折点的个数，比如nums[i] > nums[i-1]或nums[i]<nums[i+1]
 * <p>
 * 分别算一个转折点
 * <p>
 * 类似题型: Tiling a Rectangle with Fewest Squares
 * <p>
 * Airplane Seat Assignment Probability
 * <p>
 * Minimum Number of Removals to Make Mountain Array
 *
 * @author thinking_fioa 2021/4/1
 */
public class Leetcode376 {

  public int wiggleMaxLength(int[] nums) {
    if (nums.length <= 0) {
      return 0;
    }
    int result = 1;
    // 1 AES; -1 DESC
    int direction = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] == nums[i - 1]) {
        continue;
      }
      if (direction < 0 && nums[i] > nums[i - 1]) {
        result++;
      } else if (direction > 0 && nums[i] < nums[i - 1]) {
        result++;
      } else {
        if (direction == 0) {
          result++;
        }
      }
      direction = nums[i] - nums[i - 1];
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 6
//    int[] nums = {1, 7, 4, 9, 2, 5};
    // Output 7
//    int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
    // Output 2
//    int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    // Output 1
    int[] nums = {0, 0};
    Leetcode376 leetcode376 = new Leetcode376();
    ConsoleOutput.printf(leetcode376.wiggleMaxLength(nums));
  }
}
