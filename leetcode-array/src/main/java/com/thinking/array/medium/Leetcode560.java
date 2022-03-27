package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: Subarray Sum Equals K
 * <p>
 * 题目: 给定一个数组nums[]和一个整数k，数组中既有正数也有负数，求数组nums[]的子数组的个数，该子数组的和等于k
 * <p>
 * 思路：定一个映射map<Integer, Integer/>，key是表示目前[0,index]的子数组和，value是表示数组和出现的次数。
 * <p>
 * 遍历一个for从左往右循环遍历，使用sum变量记录目前的总和，在map中查找sum-k的值出现次数累加到变量result中。
 * <p>
 * 这个想法非常厉害，从目的结果出发：题目求的是子数组和等于k，那我将目前的sum-k，如果能从map中找到sum-k出现的次数
 * <p>
 * ，则代表子数组和等于k的次数
 * <p>
 * 思路2：动态规划dp[i][j]表示[i,j)的和，然后判断dp[i][j]==k，会出现Time Limit Exceeded
 * <p>
 * 类似题型：Continuous Subarray Sum
 * <p>
 * Subarray Product Less Than K
 * <p>
 * Find Pivot Index
 * <p>
 * Subarray Sums Divisible by K
 * <p>
 * Minimum Operations to Reduce X to Zero
 * <p>
 * K Radius Subarray Averages
 *
 * @author vlin 2022/3/5
 */
public class Leetcode560 {

  /**
   * faster than 29.73%，less than 24.12%
   */
  public int subarraySum(int[] nums, int k) {
    int result = 0;
    Map<Integer, Integer> mark = new HashMap<>();
    mark.put(0, 1);
    int sum = 0;
    for (int num : nums) {
      sum += num;
      if (mark.containsKey(sum - k)) {
        result += mark.get(sum - k);
      }
      mark.putIfAbsent(sum, 0);
      mark.compute(sum, (key, value) -> value + 1);
    }
    return result;
  }

  /**
   * 运行超时，Time Limit Exceeded
   */
  public int subarraySum2(int[] nums, int k) {
    int result = 0;

    int[][] dp = new int[nums.length][nums.length + 1];
    for (int step = 1; step <= nums.length; step++) {
      for (int move = 0; move < nums.length; move++) {
        if (move + step > nums.length) {
          continue;
        }
        dp[move][move + step] = dp[move][move + step - 1] + nums[move + step - 1];
        if (dp[move][move + step] == k) {
          result++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 2
    int[] nums = {1, 1, 1};
    int k = 2;

    // Output 2
//    int[] nums = {1, 2, 3};
//    int k = 3;

    Leetcode560 leetcode560 = new Leetcode560();
    ConsoleOutput.printf(leetcode560.subarraySum(nums, k));
  }
}
