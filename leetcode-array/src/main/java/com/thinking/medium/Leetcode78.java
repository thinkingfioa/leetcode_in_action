package com.thinking.medium;

import com.thinking.ConsoleOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: Subsets
 *
 * 题目: 给定一个数组nums，数组中元素各不相同，输出元素组成的集合
 *
 * 相同题目：Leetcode90
 *
 * 思路：回溯法。for循环元素，进dfs添加，出dfs执行remove.
 *
 * @author thinking_fioa 30/10/2019
 */
public class Leetcode78 {

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(result, new ArrayList<>(), nums, 0);
    return result;
  }

  public void dfs(List<List<Integer>> result, List<Integer> oneResult, int[] nums, int index) {
    result.add(new ArrayList<>(oneResult));
    if (index >= nums.length) {
      return;
    }
    for (int i = index; i < nums.length; i++) {
      oneResult.add(nums[i]);
      dfs(result, oneResult, nums, i + 1);
      oneResult.remove(oneResult.size() - 1);
    }
  }


  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    Leetcode78 leetcode78 = new Leetcode78();
    List<List<Integer>> result = leetcode78.subsets(nums);
    ConsoleOutput.printf(result);
  }
}
