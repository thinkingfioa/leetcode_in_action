package com.thinking.explore;

import com.thinking.ConsoleOutput;

/**
 * @author thinking_fioa 2020/7/19
 */
public class SearchPos {

  public int searchInsert(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int pos = (left + right) / 2;
      if (nums[pos] == target) {
        return pos;
      } else if (nums[pos] < target) {
        left = pos + 1;
      } else {
        right = pos - 1;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 6};
    int target = 2;

    SearchPos post = new SearchPos();
    ConsoleOutput.printf(post.searchInsert(nums, target));
  }

}
