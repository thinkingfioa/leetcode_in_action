package com.thinking.tree.medium;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title: Binary Tree Maximum Path Sum
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Path Sum
 * <p>
 * Sum Root to Leaf Numbers
 * <p>
 * Longest Univalue Path
 * <p>
 * Time Needed to Inform All Employees
 *
 * @author thinking_fioa 2021/7/4
 */
public class Leetcode124 {

  /**
   * faster than 32.36%, less than 80.00%
   */
  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    AtomicInteger maxV = new AtomicInteger(Integer.MIN_VALUE);
    int result = maxPathSum0(root, maxV);
    maxV.set(Math.max(result, maxV.get()));
    return maxV.get();
  }

  public int maxPathSum0(TreeNode p, AtomicInteger maxV) {
    if (p == null) {
      return 0;
    }
    int val = p.val;
    if (p.left != null && p.right != null) {
      int leftSum = maxPathSum0(p.left, maxV);
      int rightSum = maxPathSum0(p.right, maxV);
      maxV.set(maxValue(maxV.get(), val, leftSum, rightSum, val + leftSum, val + rightSum,
          val + leftSum + rightSum));
      return Math.max(val, Math.max(val + leftSum, val + rightSum));
    } else if (p.left != null) {
      int leftSum = maxPathSum0(p.left, maxV);
      maxV.set(maxValue(maxV.get(), val, leftSum, val + leftSum));
      return Math.max(val, val + leftSum);
    } else if (p.right != null) {
      int rightSum = maxPathSum0(p.right, maxV);
      maxV.set(maxValue(maxV.get(), val, rightSum, val + rightSum));
      return Math.max(val, val + rightSum);
    } else {
      return val;
    }
  }

  public int maxValue(int... num) {
    int max = num[0];
    for (int i = 1; i < num.length; i++) {
      max = Math.max(max, num[i]);
    }
    return max;
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
