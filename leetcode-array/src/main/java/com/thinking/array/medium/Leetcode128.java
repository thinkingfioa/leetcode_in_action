package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: Longest Consecutive Sequence
 * <p>
 * 题目: 给定一个未排序的数组nums[]，求出数组中连续数字的最大长度。要求时间复杂度为O(n)
 *
 * <pre>
 *   输入：0, 3, 7, 2, 5, 8, 4, 6, 0, 1
 *   输出：9
 *   解释：0, 1, 2, 3, 4, 5, 6, 7, 8连续数字的最大长度为9
 * </pre>
 * <p>
 * 思路：题目难点在于O(n)的算法复杂度，意味着只能遍历一遍。利用贪心的思路，假如遍历到nums[i]节点
 * <p>
 * 如果已经遍历过nums[i-1]和nums[i+1]，且能获取到最大的长度，最优解可能为:left + 1 + right。通俗的说
 * <p>
 * 就是nums[i]节点填补了缺口，从而得到了最优解，考虑再利用这个解来填补结果，看是否后续能得到更优解。
 * <p>
 * 定义一个Map(Integer, Integer)，key代表的是数字，value代表的是以这个点开头或结尾的最大长度。遍历到某个数nums[i]，
 * <p>
 * 查找nums[i-1]和nums[i+1]是否在Map中，计算是否得到了最优解，并且利用计算的结果来对Map做put操作，便于还会得到更优解
 * <p>
 * 类似题型：Binary Tree Longest Consecutive Sequence
 *
 * @author vlin 2021/11/30
 */
public class Leetcode128 {

  /**
   * faster than 35.53%， less than 17.02%
   */
  public int longestConsecutive(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int result = 0;
    Map<Integer, Integer> markMap = new HashMap<>();
    for (int single : nums) {
      if (!markMap.containsKey(single)) {
        int left = markMap.getOrDefault(single - 1, 0);
        int right = markMap.getOrDefault(single + 1, 0);
        result = Math.max(result, left + right + 1);
        markMap.put(single, left + right + 1);
        markMap.put(single - left, left + right + 1);
        markMap.put(single + right, left + right + 1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 9
    int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

    Leetcode128 leetcode128 = new Leetcode128();
    ConsoleOutput.printf(leetcode128.longestConsecutive(nums));
  }
}
