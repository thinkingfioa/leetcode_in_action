package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Largest Number
 * <p>
 * 题目: 给一串非负数整数nums[]，重排该数组，以得到最大的一个数字。为避免数字越界，结果使用字符串表示
 * <p>
 * 思路：假设给定两个数字num1和num2，如果能把num1和num2比较排序，那么可以使用快排对整个nums[]数组排序，
 * <p>
 * 以得到要求的数列，再组装即可。
 * <p>
 * 如何比较num1和num2随应该在第一个，谁在第二个，其实非常简单，将num1和num2都看成字符串，
 * <p>
 * 两个字符串相加得到str1="Num1Num2"和str2="Num2Num1"，比较str1和str2即可。
 * <p>
 * 类似题型：Remove Vowels from a String
 * <p>
 * Minimum Deletions to Mark String Balanced
 * <p>
 * Stone Game VI
 *
 * @author vlin 2021/12/8
 */
public class Leetcode179 {

  /**
   * faster than 50.99%，less than 5.13%
   */
  public String largestNumber(int[] nums) {
    String[] numsStr = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numsStr[i] = String.valueOf(nums[i]);
    }

    quickSort(numsStr, 0, numsStr.length - 1);
    if (numsStr[0].charAt(0) == '0') {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    for (String str : numsStr) {
      sb.append(str);
    }
    return sb.toString();
  }

  private void quickSort(String[] numsStr, int begin, int end) {
    if (begin >= end) {
      return;
    }
    int mid = quickSort0(numsStr, begin, end);
    quickSort(numsStr, begin, mid - 1);
    quickSort(numsStr, mid + 1, end);
  }

  private int quickSort0(String[] numsStr, int begin, int end) {
    String tmp = numsStr[begin];
    while (begin < end) {
      while (begin < end && cmp(tmp, numsStr[end]) >= 0) {
        end--;
      }

      numsStr[begin] = numsStr[end];
      while (begin < end && cmp(tmp, numsStr[begin]) < 0) {
        begin++;
      }
      numsStr[end] = numsStr[begin];
    }
    numsStr[begin] = tmp;
    return begin;
  }

  private int cmp(String str1, String str2) {
    return (str1 + str2).compareTo(str2 + str1);
  }

  public static void main(String[] args) {
    // Output 9534330
//    int[] nums = {3, 30, 34, 5, 9};

    // Output 1113111311
//    int[] nums = {111311, 1113};

    // Output 0
    int[] nums = {0, 0};

    Leetcode179 leetcode179 = new Leetcode179();
    ConsoleOutput.printf(leetcode179.largestNumber(nums));
  }
}
