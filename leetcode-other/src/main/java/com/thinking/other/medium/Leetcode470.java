package com.thinking.other.medium;

/**
 * Title: Implement Rand10() Using Rand7()
 * <p>
 * 题目: 给定一个方法Rand7()，可以生成一个1-7之间的随机数。让基于Rand7()方法，实现Rand10()方法
 * <p>
 * 思路: Rand7()可以生成1-7之间的随机数，那么两次调用Rand7()可以产生49种可能。49种可能不能被10平均分，
 * <p>
 * 所以只取前40种可能映射到1-10之间。
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
      rand10 = (a - 1) * 7 + b;
    } while (rand10 > 40);
    return rand10 % 10 + 1;
  }

  private int rand7() {
    return 1;
  }
}
