package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title: Permutations II
 * <p>
 * 题目：给定一个数组nums，数组nums中有重复的值，求这个数组中的全排列
 * <p>
 * 思路：由于题目中数组nums存在重复的值，所以采用DFS方法时，在统计结果的时候，需要对结果去重
 * <p>
 * 我们DFS遍历时，每一层代表是全排列的某个位置上的值，这个值需要从[0,size-1]遍历挑选出来，
 * <p>
 * 为避免数组中nums[index]多次使用，构建一个visited集合，记录已经使用过的index。
 * <p>
 * 类似题型：Palindrome Permutation II
 * <p>
 * Number of Squareful Arrays
 *
 * @author vlin 2022/3/27
 */
public class Leetcode47 {

  /**
   * faster than 6.92%，less than 5.02%
   */
  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    List<Integer> singleResult = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();
    Set<String> has = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      singleResult.add(nums[i]);
      visited.add(i);
      dfs(result, visited, has, singleResult, nums, 1);
      singleResult.remove(singleResult.size() - 1);
      visited.remove(i);
    }

    return result;
  }

  private void dfs(List<List<Integer>> result, Set<Integer> visited, Set<String> has,
      List<Integer> singleResult, int[] nums, int index) {
    if (nums.length == index) {
      String str = toResultStr(singleResult);
      if (!has.contains(str)) {
        has.add(str);
        result.add(new ArrayList<>(singleResult));
      }
      return;
    }

    if (visited.size() >= nums.length) {
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (visited.contains(i)) {
        continue;
      }
      singleResult.add(nums[i]);
      visited.add(i);
      dfs(result, visited, has, singleResult, nums, index + 1);
      singleResult.remove(singleResult.size() - 1);
      visited.remove(i);

    }
  }

  private String toResultStr(List<Integer> result) {
    StringBuilder sb = new StringBuilder();
    for (Integer one : result) {
      sb.append(one).append("_");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    // Output
//    int[] nums = {1, 2, 3};
    int[] nums = {1, 1};

    Leetcode47 leetcode47 = new Leetcode47();
    ConsoleOutput.printf(leetcode47.permuteUnique(nums));
  }
}
