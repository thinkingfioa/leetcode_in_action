package com.thinking.tree.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Kth Smallest Element in a BST
 * <p>
 * 题目: 给定一个平衡二叉树，和一个整数K，求平衡二叉树中第K个节点的值（从小到大顺序）
 * <p>
 * 思路:
 * <p>
 * 类似题型: Binary Tree Inorder Traversal
 * <p>
 * Second Minimum Node In a Binary Tree
 *
 * @author vlin 2022/3/13
 */
public class Leetcode230 {

  /**
   * faster than 100.00%，less than 97.68%
   */
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.addLast(root);
    int count = 0;
    TreeNode move = root;
    while (move != null || !stack.isEmpty()) {
      if (move == null) {
        move = stack.pollLast();
        count++;
        if (count == k) {
          return move.val;
        }
        move = move.right;
      } else {
        stack.addLast(move);
        move = move.left;
      }
    }
    return -1;
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
