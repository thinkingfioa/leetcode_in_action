package com.thinking.tree.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Check Completeness of a Binary Tree
 * <p>
 * 题目: 给定一个二叉树，判断二叉树是否是完全二叉树
 * <p>
 * 思路:
 * <p>
 * 类似题型: Delete Node in a BST
 * <p>
 * Binary Tree Pruning
 * <p>
 * Binary Search Tree Iterator II
 *
 * @author vlin 2021/12/15
 */
public class Leetcode958 {

  /**
   * faster than 70.42%，less than 26.78%
   */
  public boolean isCompleteTree(TreeNode root) {
    if (null == root) {
      return true;
    }
    int expectNum = 1;
    Deque<TreeNode> first = new ArrayDeque<>();
    Deque<TreeNode> second = new ArrayDeque<>();
    first.add(root);
    while (!first.isEmpty()) {
      if (first.size() == expectNum) {
        boolean flag = false;
        while (!first.isEmpty()) {
          TreeNode top = first.pollFirst();
          if (top.left == null && top.right != null) {
            return false;
          }
          if (top.left != null || top.right != null) {
            if (flag) {
              return false;
            }
            if (top.left != null) {
              second.add(top.left);
            }
            if (top.right != null) {
              second.add(top.right);
            }
          }
          if (top.left == null || top.right == null) {
            flag = true;
          }
        }
        first = second;
        second = new ArrayDeque<>();
        expectNum *= 2;
      } else {
        // last layer
        while (!first.isEmpty()) {
          TreeNode top = first.pollFirst();
          if (top.left != null || top.right != null) {
            return false;
          }
        }
      }
    }
    return true;
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
