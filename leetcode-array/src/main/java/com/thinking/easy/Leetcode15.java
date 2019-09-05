package com.thinking.easy;

import com.thinking.ConsoleOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author thinking_fioa 04/09/2019
 */
public class Leetcode15 {

  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> numList = new ArrayList<>();
    for (int num : nums) {
      numList.add(num);
    }
    Collections.sort(numList);
    for (int i = 0; i < numList.size(); i++) {
      if (i > 0 && numList.get(i).equals(numList.get(i - 1))) {
        continue;
      }
      int target = -numList.get(i);
      for (int p1 = i + 1, p2 = numList.size() - 1; p1 < numList.size() && p2 > p1; ) {

        if (numList.get(p1) + numList.get(p2) == target) {
          List<Integer> one = new ArrayList<>();
          one.add(numList.get(i));
          one.add(numList.get(p1));
          one.add(numList.get(p2));
          result.add(one);
          p1++;
          while (p1 < p2 && numList.get(p1).equals(numList.get(p1 - 1))) {
            p1++;
          }
          p2--;
          while (p2 > p1 && numList.get(p2).equals(numList.get(p2 + 1))) {
            p2--;
          }
        } else if (numList.get(p1) + numList.get(p2) > target) {
          p2--;
        } else {
          p1++;
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
//    int[] nums = {-2, 0, 0, 2, 2};
    Leetcode15 leetcode15 = new Leetcode15();
    ConsoleOutput.printf(leetcode15.threeSum(nums));
  }
}
