package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Median of Two Sorted Arrays
 * <p>
 * 题目: 给定两个有序的数组nums1[]和nums2[]，求两个有序数组的中位数。 难点：要求时间复杂度O(log(m+n))
 * <pre>
 *   输入: nums1 = [1,2], nums2 = [3,4]
 *   输出: 2.50000
 * </pre>
 * <p>
 * 思路1: 题目的难点在于复杂度O(log(m+n))，对于两个有序的数组，求中位数，本质上可以转化为：
 * <p>
 * 求两个数组nums1[]和nums2[]的第(m+n+1)/2和第(m+n+2)/2的位置数。这个思路非常好，这样思考就无需要关心原数组的奇数和偶数的问题了。
 * <p>
 * 那么，如果求两个数组nums1[]和nums2[]的第K个元素呢？
 * <p>
 * 答：使用二分淘汰法。在两个数组nums1[]和nums2[]中找第K个元素，那么我们每次比较nums1[k/2]和nums2[k/2]，
 * <p>
 * 第一，nums1[k/2] < nums2[k/2]，那么nums1[begin, k/2]的全部被淘汰。
 * <p>
 * 第二，nums1[k/2] > nums2[k/2]，那么nums2[begin, k/2]的全部被淘汰。
 * <p>
 * 参考：https://www.nowcoder.com/discuss/196951
 * <p>
 * 思路2: 利用归并排序，新开辟一个数组，然后即可定位中位数。该思路比较简单
 * <p>
 * 类似题型: Exclusive Time of Functions
 * <p>
 * Fixed Point
 * <p>
 * Eliminate Maximum Number of Monsters
 *
 * @author thinking_fioa 2021/10/9
 */
public class Leetcode4 {

  /**
   * faster than 99.91%，less than 89.67%
   */
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m = nums1.length;
    int n = nums2.length;
    int l = (m + n + 1) / 2;
    int r = (m + n + 2) / 2;
    return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r)) / 2.0;
  }

  private int getKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
    if (start1 > nums1.length - 1) {
      return nums2[start2 + k - 1];
    }
    if (start2 > nums2.length - 1) {
      return nums1[start1 + k - 1];
    }
    if (k == 1) {
      return Math.min(nums1[start1], nums2[start2]);
    }
    int num1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
    int num2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
    if (num1 < num2) {
      return getKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
    } else {
      return getKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
  }

  public static void main(String[] args) {
    // Output 2.00000
    int[] nums1 = {1, 3};
    int[] nums2 = {};

    Leetcode4 leetcode4 = new Leetcode4();
    ConsoleOutput.printf(leetcode4.findMedianSortedArrays(nums1, nums2));
  }
}
