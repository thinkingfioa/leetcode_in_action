package com.thinking.tree.medium;


import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title: Sum Root to Leaf Numbers
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Path Sum
 * <p>
 * Smallest String Starting From Leaf
 *
 * @author thinking_fioa 2021/8/4
 */
public class Leetcode129 {

  /**
   * faster than 100.00%,  less than 22.09%
   */
  public int sumNumbers(TreeNode root) {
    int sum = 0;
    AtomicInteger result = new AtomicInteger(0);
    calSum(root, sum, result);
    return result.get();
  }

  public void calSum(TreeNode t, int sum, AtomicInteger result) {
    if (t == null) {
      return;
    }
    if (t.left == null && t.right == null) {
      result.addAndGet(sum * 10 + t.val);
      return;
    }
    sum = sum * 10 + t.val;
    calSum(t.left, sum, result);
    calSum(t.right, sum, result);
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
