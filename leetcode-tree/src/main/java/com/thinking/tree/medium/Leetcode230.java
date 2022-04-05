package com.thinking.tree.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Kth Smallest Element in a BST
 * <p>
 * 题目: 给定一个平衡二叉树，和一个整数K，求平衡二叉树中第K个节点的值（从小到大顺序）
 * <p>
 * 思路: 题目本质是平衡二叉树的中序遍历。构建一个栈，从move=root节点开始遍历，如果当前move节点不空，先入栈
 * <p>
 * 然后进入move=move.left。如果move节点为空，则从栈顶弹出一个元素，并做count++计数，当count==k时，则是题目
 * <p>
 * 要求的第K个节点的值
 * <p>
 * 类似题型: Binary Tree Inorder Traversal
 * <p>
 * Second Minimum Node In a Binary Tree
 *
 * @author vlin 2022/3/13
 */
public class Leetcode230 {

  /**
   * faster than 100.00%，less than 97.68%
   */
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    int count = 0;
    TreeNode move = root;
    while (move != null || !stack.isEmpty()) {
      if (move == null) {
        move = stack.pollLast();
        count++;
        if (count == k) {
          return move.val;
        }
        move = move.right;
      } else {
        stack.addLast(move);
        move = move.left;
      }
    }
    return -1;
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
