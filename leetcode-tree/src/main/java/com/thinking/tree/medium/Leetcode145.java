package com.thinking.tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: Binary Tree Postorder Traversal
 * <p>
 * 题目: 给定一个二叉树，要求使用非递归方式后序遍历。
 * <p>
 * 思路:
 * <p>
 * 类似题型: Binary Tree norder traversal
 * <p>
 * N-ary tree Postorder Traversal
 *
 * @author vlin 2022/1/9
 */
public class Leetcode145 {

  /**
   * faster than 30.04%， less than 30.15%
   */
  public List<Integer> postorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    List<Integer> result = new ArrayList<>();

    TreeNode pre = root;
    deque.addLast(root);
    while (!deque.isEmpty()) {
      TreeNode top = deque.pollLast();
      if (top.left == null && top.right == null) {
        result.add(top.val);
        pre = top;
        continue;
      }
      if (top.right == pre || top.left == pre) {
        result.add(top.val);
        pre = top;
        continue;
      }
      deque.addLast(top);
      if (top.right != null) {
        deque.addLast(top.right);
      }
      if (top.left != null) {
        deque.addLast(top.left);
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
