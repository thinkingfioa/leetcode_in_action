package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: First Missing Positive
 * <p>
 * 题目: 给定一个无序的数组nums[]，找到数组中第一个未出现的正整数
 * <pre>
 *   input     3,4,-1,1
 *   output    2
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 思路2：比较简单的想法是，先对数组排序，然后再找第一个未出现的正整数。但题目最终的要求是O(n)和常量的空间
 * <p>
 * 类似题型:
 *
 * @author vlin 2021/11/9
 */
public class Leetcode41 {

  public int firstMissingPositive(int[] nums) {
    
  }

  public static void main(String[] args) {
    // Output 2
    int[] nums = {3, 4, -1, 1};

    Leetcode41 leetcode41 = new Leetcode41();
    ConsoleOutput.printf(leetcode41.firstMissingPositive(nums));
  }
}
