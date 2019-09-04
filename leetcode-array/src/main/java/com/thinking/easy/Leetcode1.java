package com.thinking.easy;

import com.thinking.ConsoleOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * @author thinking_fioa 03/09/2019
 */
public class Leetcode1 {

  /**
   * key is num, value is index.
   */
  private Map<Integer, Integer> map = new HashMap<>();

  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int suplus = target - nums[i];
      if (map.containsKey(suplus) && i != map.get(suplus)) {
        return new int[]{i, map.get(suplus)};
      }
    }
    return null;
  }

  public static void main(String[] args) {
    Leetcode1 leetcode1 = new Leetcode1();
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    ConsoleOutput.printf(leetcode1.twoSum(nums, target));
  }
}
