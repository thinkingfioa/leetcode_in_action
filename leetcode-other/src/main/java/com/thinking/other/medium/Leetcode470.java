package com.thinking.other.medium;

/**
 * Title: Implement Rand10() Using Rand7()
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Count Primes
 * <p>
 * Rang Addition II
 * <p>
 * Number of Ways to Reorder Array to Get Same BST
 *
 * @author thinking_fioa 2021/7/25
 */
public class Leetcode470 {

  /**
   * faster than 98.78%，less than 73.43%
   */
  public int rand10() {
    int rand10 = 0;
    do {
      int a = rand7();
      int b = rand7();
      rand10 = (a - 1) * 7 + b - 1;
    } while (rand10 > 40);
    return rand10 % 10 + 1;
  }

  private int rand7() {
    return 1;
  }
}
