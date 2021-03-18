package com.thinking.two.pointers.medium;

import com.thinking.ConsoleOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: 4Sum
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: 3Sum
 * <p>
 * 3Sum Closest
 *
 * @author thinking_fioa 2021/3/16
 */
public class Leetcode18 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length <= 3) {
      return result;
    }
    Arrays.sort(nums);
    int p1 = 0;
    int p4 = nums.length - 1;
    return result;
  }


  public static void main(String[] args) {
    // Outout [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    Leetcode18 leetcode18 = new Leetcode18();
    ConsoleOutput.printf(leetcode18.fourSum(nums, target));
  }
}
