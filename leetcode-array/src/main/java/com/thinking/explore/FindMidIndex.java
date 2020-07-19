package com.thinking.explore;

import com.thinking.ConsoleOutput;

/**
 * @author thinking_fioa 2020/7/19
 */
public class FindMidIndex {

  public int pivotIndex(int[] nums) {
    if (nums.length < 1 || nums.length == 2) {
      return -1;
    }

    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
    }

    int leftSum = 0;
    for (int i = 0; i < nums.length; i++) {
      if ((leftSum == (sum - nums[i]) / 2) && ((sum - nums[i]) % 2 == 0)) {
        return i;
      } else {
        leftSum += nums[i];
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1, 7, 3, 6, 5, 6};
//    int[] nums = {1, 2, 3};
//    int[] nums = {-1, -1, -1, -1, -1, -1};
    FindMidIndex index = new FindMidIndex();
    ConsoleOutput.printf(index.pivotIndex(nums));
  }

}
