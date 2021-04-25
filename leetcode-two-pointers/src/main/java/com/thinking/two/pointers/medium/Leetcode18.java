package com.thinking.two.pointers.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Title: 4Sum
 * <p>
 * 题目: 给定一个数字数组nums和一个target。从数组nums中找到a、b、c和d，使得a+b+c+d=target。要求将所有找到的结果输出，并且结果不能重复
 * <p>
 * 思路: 需要找四个数，我们只能分而治之，先定位a、d两个数，然后剩余的中间部分采用Two Pointer方法来寻找b+c=target-a-d。
 * <p>
 * 定位a、d两个数没有其他方式，只能遍历寻找，否则会遗漏。剩余中间部分b、c两个数，可以使用Two Pointer方法来定位
 * <p>
 * 类似题型: 3Sum
 * <p>
 * 3Sum Closest
 * <p>
 * 4Sum II
 *
 * @author thinking_fioa 2021/3/16
 */
public class Leetcode18 {

  public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums.length <= 3) {
      return result;
    }
    Arrays.sort(nums);
    Set<String> hasResult = new HashSet<>();
    int len = nums.length;
    for (int p1 = 0; p1 < len - 3; p1++) {
      for (int p4 = p1 + 3; p4 < len; p4++) {
        int surplus = target - nums[p1] - nums[p4];
        twoSum(nums, p1, p4, surplus, result, hasResult);
      }
    }
    return result;
  }

  private void twoSum(int[] nums, int p1, int p4, int surplus, List<List<Integer>> result,
      Set<String> hasResult) {
    int p2 = p1 + 1;
    int p3 = p4 - 1;
    findTwoSum(nums, p1, p2, p3, p4, surplus, result, hasResult);
  }

  private void findTwoSum(int[] nums, int p1, int p2, int p3, int p4, int surplus,
      List<List<Integer>> result, Set<String> hasResult) {
    if (p2 >= p3) {
      return;
    }
    int subSum = nums[p2] + nums[p3];
    if (subSum == surplus) {
      addResult(nums, p1, p2, p3, p4, result, hasResult);
      findTwoSum(nums, p1, p2 + 1, p3, p4, surplus, result, hasResult);
      findTwoSum(nums, p1, p2, p3 - 1, p4, surplus, result, hasResult);
    } else if (subSum > surplus) {
      findTwoSum(nums, p1, p2, p3 - 1, p4, surplus, result, hasResult);
    } else {
      findTwoSum(nums, p1, p2 + 1, p3, p4, surplus, result, hasResult);
    }
  }

  private void addResult(int[] nums, int p1, int p2, int p3, int p4, List<List<Integer>> result,
      Set<String> hasResult) {
    String key = generateKey(nums, p1, p2, p3, p4);
    if (hasResult.contains(key)) {
      return;
    }
    hasResult.add(key);
    List<Integer> single = new ArrayList<>();
    single.add(nums[p1]);
    single.add(nums[p2]);
    single.add(nums[p3]);
    single.add(nums[p4]);
    result.add(single);
  }

  private String generateKey(int[] nums, int p1, int p2, int p3, int p4) {
    StringBuilder sb = new StringBuilder();
    sb.append(nums[p1]).append("_").append(nums[p2]).append("_").append(nums[p3]).append("_")
        .append(nums[p4]).append("_");
    return sb.toString();
  }

  public static void main(String[] args) {
    // Outout [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    Leetcode18 leetcode18 = new Leetcode18();
    ConsoleOutput.printf(leetcode18.fourSum(nums, target));
  }
}
