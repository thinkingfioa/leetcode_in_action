package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: Permutations
 * <p>
 * 题目: 给定一个数组nums，其中所有的数字都不相同。返回数组nums组成的全排列
 * <p>
 * 思路:
 * <p>
 * 方法二: DFS解法，由于题目中意思是所有的数字都不相同，我们每次可以都从index=0下标开始遍历数组nums。如果数字已经存在，我们就忽略
 * <p>
 * 类似题型:Permutations II
 * <p>
 * Permutation Sequence
 * <p>
 * <p>
 * Combinations
 *
 * @author thinking_fioa 2021/5/29
 */
public class Leetcode46 {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    // TODO 方法一
    return result;
  }

  /**
   * faster than 42.81%，less than 69.17%
   */
  public List<List<Integer>> permute2(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    dfs(nums, result, new ArrayList<>());
    return result;
  }

  public void dfs(int[] nums, List<List<Integer>> result, List<Integer> singleResult) {
    if (singleResult.size() >= nums.length) {
      result.add(new ArrayList<>(singleResult));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (singleResult.contains(nums[i])) {
        continue;
      }
      singleResult.add(nums[i]);
      dfs(nums, result, singleResult);
      singleResult.remove(singleResult.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 6};

    Leetcode46 leetcode46 = new Leetcode46();

    List<List<Integer>> result = leetcode46.permute(nums);
    ConsoleOutput.printf(result);
  }
}
