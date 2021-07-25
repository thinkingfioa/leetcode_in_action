package com.thinking.tree.medium;


import java.util.ArrayList;
import java.util.List;

/**
 * Title: Path Sum II
 * <p>
 * 题目: 给定一个二叉树root，和一个数组targetSum。求出二叉树中从根节点到叶子节点相加和等于targetSum。
 * <p>
 * 思路: 利用先序遍历递归实现的思路，访问当前节点入栈，并执行targetSum'-p.val。递归结束后，移除。
 * <p>
 * 递归结束条件是: t->left == null && t->right == null && targetSum'==p.val
 * <p>
 * 类似题型: Path Sum
 * <p>
 * Binary Tree Paths
 * <p>
 * Path Sum III
 * <p>
 * Path Sum IV
 *
 * @author thinking_fioa 2021/7/21
 */
public class Leetcode113 {

  /**
   * faster than 99.98%, less than 39.64%
   */
  public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> single = new ArrayList<>();
    preOrder(result, single, root, targetSum);
    return result;
  }

  private void preOrder(List<List<Integer>> result, List<Integer> single, TreeNode t,
      int targetSum) {
    if (t == null) {
      return;
    }
    if (t.left == null && t.right == null && targetSum == t.val) {
      List<Integer> copy = new ArrayList<>(single);
      copy.add(t.val);
      result.add(copy);
      return;
    }
    single.add(t.val);
    preOrder(result, single, t.left, targetSum - t.val);
    preOrder(result, single, t.right, targetSum - t.val);
    single.remove(single.size() - 1);
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
