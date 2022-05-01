package com.thinking.array.hard;

import com.thinking.common.ConsoleOutput;

/**
 * Title: K-th Smallest in Lexicographical Order
 * <p>
 * 题目: 给定两个整数n和k，求有n组成的数字，按照字典序排序，第k个元素
 * <pre>
 *   input: n = 13, k=2
 *   output: 10。因为n=13的字典序数组[1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，第2个元素是10.
 * </pre>
 * <p>
 * 思路: 如果题目使用DFS算法遍历，肯定会超时。给定一个第一个整数n，如果我们展开字典序数组，是一个满是十叉树。
 * <p>
 * 满十叉树可以根据满十叉树特点计算从某个节点开始，计算这个节点的总数。这样我们可以逐步的逼近第k个数，
 * <p>
 * 类似题型: Map Sum Pairs
 * <p>
 * Number of Matching Subsequences
 * <p>
 * Camelcase Matching
 *
 * @author vlin 2022/4/16
 */
public class Leetcode440 {

  /**
   * faster than 100.00%，less than 95.97%
   */
  public int findKthNumber(int n, int k) {
    if (k == 1) {
      return 1;
    }
    long count = 0;
    long cur = 1;
    while (count < k) {
      int num = calNodeNum(cur, n);
      if (count + num < k) {
        count += num;
        cur++;
      } else {
        cur = cur * 10;
        count++;
      }
    }
    return (int) (cur / 10);
  }

  private int calNodeNum(long i, int n) {
    long iLeft = i;
    long iRight = i;
    int num = 0;
    while (iLeft <= n) {
      num += iRight - iLeft + 1;
      iLeft = iLeft * 10;
      iRight = Math.min(iRight * 10 + 9, n);
    }
    return num;
  }

  public static void main(String[] args) {
    // Output 10
    int n = 13, k = 2;

    Leetcode440 leetcode440 = new Leetcode440();
    ConsoleOutput.printf(leetcode440.findKthNumber(n, k));
  }
}
