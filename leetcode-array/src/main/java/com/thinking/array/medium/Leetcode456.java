package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: 132 Pattern
 * <p>
 * 题目: 给定一个数组nums，求数组中是否存在132模式的数字存在。即: i< j < k && nums[i] < nums[k] < nums[j]
 * <p>
 * 思路: 题目的突破口在于第二大的数nums[k]。从数组的右边往左遍历，如果我们能发现存在第二大的数nums[k]，且发现当前遍历的nums[i]<nums[k]
 * <p>
 * 即说明数组nums中存在132的模式。此过程为了能找到第二大的数nums[k]，需要借助栈。
 * <p>
 * 第一步：如果发现nums[i]<nums[k]，即找到了解。因为nums[k]是从右往左目前的第二大的数
 * <p>
 * 第二步：如果stack是空的，直接入栈
 * <p>
 * 第三步：如果发现nums[i]>stack.top，说明stack.top可能第二大的数nums[k]，所以我们将栈顶弹出，尝试更新
 * <p>
 * 第四步：如果发现nums[i]<stack.top，直接入栈，供后续的数来判断
 * <p>
 * 类似题型: Combinations
 * <p>
 * Smallest Good Bese
 * <p>
 * Bold Words in String
 *
 * @author thinking_fioa 2021/10/12
 */
public class Leetcode456 {

  /**
   * faster than 36.62%，less than 21.90%
   */
  public boolean find132pattern(int[] nums) {
    int second = Integer.MIN_VALUE;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = nums.length - 1; i >= 0; i--) {
      if (nums[i] < second) {
        return true;
      }
      while (!stack.isEmpty() && nums[i] > stack.peek()) {
        second = stack.peek();
        stack.pop();
      }
      stack.push(nums[i]);
    }
    return false;
  }

  /**
   * 动态规划，超时
   */
  public boolean find132pattern2(int[] nums) {
    int[][] dp = new int[nums.length][nums.length];
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          dp[i][j] = nums[i];
        } else if (i + 1 == j) {
          dp[i][j] = Math.max(nums[i], nums[j]);
        } else {
          dp[i][j] = Integer.MIN_VALUE;
        }
      }
    }
    for (int d = 2; d < nums.length; d++) {
      for (int i = 0; i + d < nums.length; i++) {
        if (nums[i] < dp[i + 1][i + d - 1] && nums[i + d] < dp[i + 1][i + d - 1]
            && nums[i] < nums[i + d]) {
          return true;
        } else {
          dp[i][i + d] = Math.max(Math.max(nums[i], nums[i + d]), dp[i + 1][i + d - 1]);
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    // Outout true
//    int[] nums = {-1, 3, 2, 0};

    // Output true
    int[] nums = {3, 1, 4, 2};

    Leetcode456 leetcode456 = new Leetcode456();
    ConsoleOutput.printf(leetcode456.find132pattern(nums));
  }
}
