package com.thinking.tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: Binary Tree Right Side View
 * <p>
 * 题目: 给定一个二叉树，求从二叉树右边观察这个树，从上到下看到的值
 * <p>
 * 思路: 利用队列实现层次遍历，每一层中最后一个节点是我们需要纪录的结果值，进行当前层遍历时，把当前层的所有左右子树加到队列中
 *
 * <p>
 * 类似题型: Populating Next Right Pointers in Each Node
 * <p>
 * Boundary of Binary Tree
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
