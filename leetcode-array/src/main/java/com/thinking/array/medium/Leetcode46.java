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
 * 方法一:
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

  /**
   * faster than 6.47%，less than 5.03%
   */
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    recuDfsSwap(nums, result, 0);
    return result;
  }

  public void recuDfsSwap(int[] nums, List<List<Integer>> result, int index) {
    if (index >= nums.length) {
      result.add(toList(nums));
      return;
    }
    for (int i = index; i < nums.length; i++) {
      swap(nums, index, i);
      recuDfsSwap(nums, result, index + 1);
      swap(nums, index, i);
    }
  }

  private List<Integer> toList(int[] nums) {
    List<Integer> single = new ArrayList<>();
    for (Integer num : nums) {
      single.add(num);
    }
    return single;
  }

  private void swap(int[] nums, int fIndex, int sIndex) {
    int tmp = nums[fIndex];
    nums[fIndex] = nums[sIndex];
    nums[sIndex] = tmp;
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
    int[] nums = {1, 4, 5, 6};

    Leetcode46 leetcode46 = new Leetcode46();

    List<List<Integer>> result = leetcode46.permute(nums);
    System.out.println(result.size());
    ConsoleOutput.printf(result);
  }
}
