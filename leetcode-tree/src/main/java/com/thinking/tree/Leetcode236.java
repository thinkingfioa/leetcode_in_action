package com.thinking.tree;

/**
 * Title: Lowest Common Ancestor of a Binary Tree
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Lowest Common Ancestor of a Binary Search Tree
 * <p>
 * Smallest Common Region
 * <p>
 * Lowest Common Ancestor of a Binary Tree II
 * <p>
 * Lowest Common Ancestor of a Binary Tree III
 * <p>
 * Lowest Common Ancestor of a Binary Tree IV
 *
 * @author thinking_fioa 2021/5/25
 */
public class Leetcode236 {

  /**
   * faster than 5.01%, less than 80.36%
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.val != p.val && root.val != q.val) {
      if (findNode(root.left, p) && findNode(root.right, q)
          || findNode(root.left, q) && findNode(root.right, p)) {
        return root;
      } else {
        TreeNode leftResult = lowestCommonAncestor(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor(root.right, p, q);
        if (leftResult != null) {
          return leftResult;
        } else {
          return rightResult;
        }
      }
    }
    if (root.val == p.val) {
      if (findNode(root.left, q) || findNode(root.right, q)) {
        return root;
      } else {
        return null;
      }
    } else {
      if (findNode(root.left, p) || findNode(root.right, p)) {
        return root;
      } else {
        return null;
      }
    }
  }

  private boolean findNode(TreeNode tree, TreeNode n) {
    if (null == tree) {
      return false;
    }
    if (tree.val == n.val) {
      return true;
    }
    return findNode(tree.left, n) || findNode(tree.right, n);
  }

  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
