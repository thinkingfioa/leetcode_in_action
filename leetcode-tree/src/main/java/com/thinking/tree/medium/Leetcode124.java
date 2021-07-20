package com.thinking.tree.medium;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title: Binary Tree Maximum Path Sum
 * <p>
 * 题目: 给定一个二叉树，找出二叉数中的一条path，这条path的和最大，每个节点只能使用一次，无需必须过root节点。
 * <p>
 * 思路: 假设遍历到节点p，需要求出的path路径有几种可能:
 * <p>
 * 一：和p节点无关，那么就是p的左子树的出得sumLeft和就是p的左子树的出得sumRight比较
 * <p>
 * 二：和p节点有关，那么应该是p左子树+p节点、或p右子树+p节点或者是p左子树+p节点+p的右子树
 * <p>
 * 上诉场景下对二叉树遍历，边遍历边求最大值即可
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
