package com.thinking.tree.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Title: Maximum Width of Binary Tree
 * <p>
 * 题目: 给一个二叉树，求二叉树的层的最大宽度节点，以非空left和非空right之间节点计算。同时注意，如果left或right
 * <p>
 * 中间有空节点也算。
 * <pre>
 *   input :                        1
 *                     2                          3
 *              5           null          null         9
 *         6      null  null   null   null   null  null    7
 *   output : 8
 * </pre>
 * <p>
 * 思路: 计算二叉树节点层次中的最大宽度，夹在中间的null节点也算。假如我们直到某个节点所对应的二叉树的序号index
 * <p>
 * ，那么其左孩子节点则是2*index，右孩子节点则是2*index+1。其实题目的本质就是求每层算出层次中的最大值。
 * <p>
 * 利用DFS算法，层次递归，每层保存最大的宽度，遍历过程中找到题目层的最大节点宽度。
 * <p>
 * 类似题型: Minesweeper
 * <p>
 * Flood Fill
 * <p>
 * Check If Two Expression Trees are Equivalent
 *
 * @author vlin 2022/2/8
 */
public class Leetcode662 {

  /**
   * faster than 71.36%，less than 8.15%
   */
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    AtomicInteger result = new AtomicInteger(0);
    List<Integer> list = new LinkedList<>();
    dfs(root, list, 1, 1, result);
    return result.get();
  }

  private void dfs(TreeNode move, List<Integer> list, int level, int index, AtomicInteger result) {
    if (move == null) {
      return;
    }

    if (level > list.size()) {
      list.add(index);
    }
    result.set(Math.max(result.get(), index - list.get(level - 1) + 1));

    dfs(move.left, list, level + 1, 2 * index, result);
    dfs(move.right, list, level + 1, 2 * index + 1, result);
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
