package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: Subsets II
 * <p>
 * 题目: 给一个数字的数组nums，数组中可能有重复的数字。求出所有的可能的子集，子集不允许重复
 * <p>
 * 思路: 一道典型的DFS解决思路，循环遍历数组，取下每位数字到数组中。
 * <p>
 * 由于子集不允许重复，可以先排序，然后剔除剔除相同的元素
 * <p>
 * 类似题型: Wildcard Matching
 * <p>
 * Sum of Subarray Minimums
 * <p>
 * Design an Ordered Stream
 *
 * @author thinking_fioa 2021/4/7
 */
public class Leetcode90 {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> single = new ArrayList<>();
    result.add(copy(single));
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 || nums[i - 1] != nums[i]) {
        single.add(nums[i]);
        dfs(result, single, nums, i);
        single.remove(single.size() - 1);
      }
    }
    return result;
  }

  private void dfs(List<List<Integer>> result, List<Integer> single, int[] nums, int index) {
    if (index >= nums.length) {
      return;
    }
    result.add(copy(single));
    for (int i = index + 1; i < nums.length; i++) {
      if (i == index + 1 || nums[i - 1] != nums[i]) {
        single.add(nums[i]);
        dfs(result, single, nums, i);
        single.remove(single.size() - 1);
      }
    }
  }

  private List<Integer> copy(List<Integer> other) {
    return new ArrayList<>(other);
  }

  public static void main(String[] args) {
    // Output [[],[1],[1,2],[1,2,2],[2],[2,2]]
//    int[] nums = {1, 2, 2};
    // Output [[],[0]]
//    int[] nums = {0};
    // Output [[],[1],[1,4],[1,4,4],[1,4,4,4],[1,4,4,4,4],[4],[4,4],[4,4,4],[4,4,4,4]]
    int[] nums = {4, 4, 4, 1, 1, 4};
    Leetcode90 leetcode90 = new Leetcode90();
    ConsoleOutput.printf(leetcode90.subsetsWithDup(nums));
  }
}
