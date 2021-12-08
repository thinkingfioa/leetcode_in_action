package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Largest Number
 * <p>
 * 题目:
 * <p>
 * 思路：
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
