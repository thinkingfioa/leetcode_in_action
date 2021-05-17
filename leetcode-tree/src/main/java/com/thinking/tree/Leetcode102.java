package com.thinking.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: Binary Tree Level Order Traversal
 * <p>
 * 题目: 二叉树的层级遍历
 * <p>
 * 思路:
 * <p>
 * 类似题型: Binary Tree Zigzag Level Order Traversal
 * <p>
 * Binary Tree Vertical Order Traversal
 * <p>
 * Binary Tree Level Order Traversal II
 * <p>
 * Minimum Depth of Binary Tree
 * <p>
 * Average of Levels in Binary Tree
 * <p>
 * N-ary Tree Level Order Traversal
 * <p>
 * Cousins in Binary Tree
 *
 * @author thinking_fioa 2021/5/17
 */
public class Leetcode102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (null == root) {
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> queue = null;
    Deque<TreeNode> nextQueue = new ArrayDeque<>();
    nextQueue.add(root);
    while (!nextQueue.isEmpty()) {
      List<Integer> singleResult = new ArrayList<>();
      queue = nextQueue;
      nextQueue = new ArrayDeque<>();
      while (!queue.isEmpty()) {
        TreeNode curNoe = queue.pop();
        if (curNoe.left != null) {
          nextQueue.add(curNoe.left);
        }
        if (curNoe.right != null) {
          nextQueue.add(curNoe.right);
        }
        singleResult.add(curNoe.val);
      }
      result.add(singleResult);
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
