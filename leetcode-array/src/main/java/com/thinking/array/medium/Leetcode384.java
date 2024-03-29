package com.thinking.array.medium;

import java.util.Arrays;
import java.util.Random;

/**
 * Title: Shuffle an Array
 * <p>
 * 题目: 给定一个数组nums，设计一个算法随机的移动数组中的两个数，所有全排列的都是等价的被移动
 * <p>
 * 思路: 洗牌算法。我们从数组nums的下标来思考这个问题。所谓洗牌算法，就是每次从候选的数字中抓阄，放到对应的位置下。
 * <p>
 * 从[0, nums.length)开始遍历循环，比如当前访问到index=i时，应该从[i, length)中随机挑选一个放到nums[i]下。
 * <p>
 * 类似题型: Power of Two
 * <p>
 * Minimum Moves to Equal Array Elements
 * <p>
 * Stone Game VI
 *
 * @author vlin 2022/4/17
 */
public class Leetcode384 {

  /**
   * faster than 79.93%，less than 74.61%
   */
  class Solution {

    private int[] origNums;
    private int[] nums;

    public Solution(int[] nums) {
      this.origNums = Arrays.copyOf(nums, nums.length);
      this.nums = nums;
    }

    public int[] reset() {
      this.nums = Arrays.copyOf(this.origNums, this.origNums.length);
      return this.nums;
    }

    public int[] shuffle() {
      Random ran = new Random();

      for (int i = 0; i < nums.length; i++) {
        int t = ran.nextInt(nums.length - i) + i;
        swap(nums, i, t);
      }

      return this.nums;
    }

    private void swap(int[] nums, int one, int to) {
      int tmp = nums[one];
      nums[one] = nums[to];
      nums[to] = tmp;
    }
  }

  /**
   * Your Solution object will be instantiated and called as such:
   * Solution obj = new Solution(nums);
   * int[] param_1 = obj.reset();
   * int[] param_2 = obj.shuffle();
   */
}
