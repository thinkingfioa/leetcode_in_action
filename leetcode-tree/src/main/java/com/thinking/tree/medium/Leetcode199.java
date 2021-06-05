package com.thinking.tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: Binary Tree Right Side View
 * <p>
 * 题目:
 * <p>
 * 思路1: 递归
 * <p>
 * 思路2: 非递归
 *
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/6/5
 */
public class Leetcode199 {

  /**
   * faster than 10.07%，less than 6.33%
   */
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }
    List<Integer> result = new ArrayList<>();
    Deque<TreeNode> list = new ArrayDeque<>();
    list.add(root);
    while (!list.isEmpty()) {
      int size = list.size();
      for (int i = 0; i < size; i++) {
        TreeNode top = list.pop();
        if (i == size - 1) {
          result.add(top.val);
        }
        if (top.left != null) {
          list.add(top.left);
        }
        if (top.right != null) {
          list.add(top.right);
        }
      }
    }
    return result;
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
