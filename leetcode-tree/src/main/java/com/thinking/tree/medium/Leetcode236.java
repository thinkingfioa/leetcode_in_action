package com.thinking.tree.medium;

/**
 * Title: Lowest Common Ancestor of a Binary Tree
 * <p>
 * 题目: 给一个二叉树root，和p, q两个节点。找出p，q节点的最近的共同父亲。
 * <p>
 * 思路1: 递归思路。找root->left分支是否有p,q节点；找root->right分支是否有p,q节点。如果root左右节点都有，那最新的共同父亲就是root
 * <p>
 * 如果只有左右节点只有一个非空，接下来两种情况: 1. 非空的分支返回值已经是最近的共同父亲；2. 非空分支只有一个节点，仍需递归。这两种情况都是
 * <p>
 * 直接将找到的非空节点返回。
 * <p>
 * 思路2: 写法较啰嗦，不推荐
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
   * faster than 33.43%, less than 14.35%
   */
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == p || root == q || null == root) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);
    if (left != null && right != null) {
      return root;
    }
    return null != left ? left : right;
  }

  /**
   * faster than 5.01%, less than 80.36%
   */
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.val != p.val && root.val != q.val) {
      if (findNode(root.left, p) && findNode(root.right, q)
          || findNode(root.left, q) && findNode(root.right, p)) {
        return root;
      } else {
        TreeNode leftResult = lowestCommonAncestor2(root.left, p, q);
        TreeNode rightResult = lowestCommonAncestor2(root.right, p, q);
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
