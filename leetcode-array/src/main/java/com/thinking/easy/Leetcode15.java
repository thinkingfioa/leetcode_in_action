package com.thinking.easy;

import com.thinking.ConsoleOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author thinking_fioa 04/09/2019
 */
public class Leetcode15 {

  private Set<String> markSet = new HashSet<String>();

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    for (int m = 0; m < nums.length; m++) {
      for (int k = m + 1; k < nums.length; k++) {
        for (int n = k + 1; n < nums.length; n++) {
          if (nums[m] + nums[k] + nums[n] == 0) {
            String key = generateKey(nums[m], nums[k], nums[n]);
            if (!markSet.contains(key)) {
              List<Integer> one = new ArrayList<>();
              one.add(nums[m]);
              one.add(nums[k]);
              one.add(nums[n]);
              result.add(one);
              markSet.add(key);
            }
          }
        }
      }
    }
    return result;
  }

  public String generateKey(Integer... numlist) {
    Collections.sort(Arrays.asList(numlist));
    StringBuilder sb = new StringBuilder();
    for (Integer n : numlist) {
      sb.append(n).append("_");
    }
    return sb.toString();
  }


  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    Leetcode15 leetcode15 = new Leetcode15();
    ConsoleOutput.printf(leetcode15.threeSum(nums));
  }
}
