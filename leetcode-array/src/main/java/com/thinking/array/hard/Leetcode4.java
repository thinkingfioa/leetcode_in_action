package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Median of Two Sorted Arrays
 * <p>
 * 题目:
 * <p>
 * 思路1: https://www.nowcoder.com/discuss/196951
 * <p>
 * 思路2: 利用归并排序，新开辟一个数组，然后即可定位中位数
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/10/9
 */
public class Leetcode4 {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
  }

  public static void main(String[] args) {
    // Output 2.00000
    int[] nums1 = {1, 3};
    int[] nums2 = {};

    Leetcode4 leetcode4 = new Leetcode4();
    ConsoleOutput.printf(leetcode4.findMedianSortedArrays(nums1, nums2));
  }
}
