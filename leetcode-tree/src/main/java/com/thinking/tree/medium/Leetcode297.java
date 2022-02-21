package com.thinking.tree.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Serialize and Deserialize Binary Tree
 * <p>
 * 题目: 序列化和反序列化一个二叉树。给定一个二叉树，提供序列化和反序列化功能
 * <p>
 * 思路:
 * <p>
 * 类似题型: Encode and Decode Strings
 * <p>
 * Serialize and Deserialize BST
 * <p>
 * Find Duplicate Subtrees
 * <p>
 * Serialize and Deserialize N-ary Tree
 *
 * @author vlin 2022/2/9
 */
public class Leetcode297 {

  private static final TreeNode EMPTY = new TreeNode(Integer.MIN_VALUE);
  private static final String SPLIT = ",";

  /**
   * faster then 41.45%, less than 41.00%
   */
  public String serialize(TreeNode root) {
    if (root == null) {
      return "";
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();
    deque.add(root);
    while (!deque.isEmpty()) {
      TreeNode top = deque.pollFirst();
      sb.append(top.val).append(SPLIT);
      if (top == EMPTY) {
        continue;
      }
      if (top.left == null) {
        deque.addLast(EMPTY);
      } else {
        deque.addLast(top.left);
      }
      if (top.right == null) {
        deque.addLast(EMPTY);
      } else {
        deque.addLast(top.right);
      }
    }
    return sb.toString();
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    if (null == data || "".equals(data)) {
      return null;
    }

    String[] treeNode = data.split(SPLIT);
    TreeNode root = new TreeNode(Integer.parseInt(treeNode[0]));
    Deque<TreeNode> layer = new ArrayDeque<>();
    layer.addLast(root);
    for (int i = 1; i < treeNode.length; i = i + 2) {
      if (null == treeNode[i] || "".equals(treeNode[i])) {
        break;
      }

      TreeNode cur = layer.pollFirst();
      // left
      int valLeft = Integer.parseInt(treeNode[i]);
      if (valLeft == Integer.MIN_VALUE) {
        cur.left = null;
      } else {
        cur.left = new TreeNode(valLeft);
        layer.addLast(cur.left);
      }
      if (i + 1 >= treeNode.length) {
        continue;
      }
      // right
      int valRight = Integer.parseInt(treeNode[i + 1]);
      if (valRight == Integer.MIN_VALUE) {
        cur.right = null;
      } else {
        cur.right = new TreeNode(valRight);
        layer.addLast(cur.right);
      }
    }

    return root;
  }

  public static class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
