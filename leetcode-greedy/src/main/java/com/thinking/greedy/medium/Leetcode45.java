package com.thinking.greedy.medium;

import com.thinking.ConsoleOutput;

/**
 * Title: Jump Game II
 * <p>
 * 题目: 给一串非负数的数组nums，数组nums中的每个元素代表基于当前位置能跳的最远距离。假定给定的数组nums总是能到最后一个节点。
 * <p>
 * 请输出最少的跳数
 * <p>
 * 思路: 该题思路与Jump Game类似。假设你当前位于0下标的数组位置，最远能跳nums[0]的距离，那么第一跳只能跳到nums[0]的位置。
 * <p>
 * 第二跳应该只能在[0, nums[0]]的候选点中找最远的，假设找到第二跳最好在A点(0<A<=nums[0]），能跳到最远点在nums[A]位置。
 * <p>
 * 第三跳应该在[A, nums[A]]之间的位置找最远点。依次类推，每次找一个候选点，就是一跳。
 * <p>
 * 类似题型: Jump Game
 *
 * @author thinking_fioa 2021/3/14
 */
public class Leetcode45 {

  public int jump(int[] nums) {
    int result = 0;
    int maxJump = nums[0];
    int i = 1;
    while (i <= maxJump && i < nums.length) {
      int localMaxJump = maxJump;
      while (i <= maxJump && i < nums.length) {
        localMaxJump = Math.max(localMaxJump, nums[i] + i);
        i++;
      }
      result++;
      maxJump = localMaxJump;
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 2
//    int[] nums = {2, 3, 1, 1, 4};
    // Output 2
    int[] nums = {2, 3, 0, 1, 4};
    Leetcode45 leetcode45 = new Leetcode45();
    ConsoleOutput.printf(leetcode45.jump(nums));
  }
}
