package com.thinking.tree.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Title: Binary Tree Zigzag Level Order Traversal
 * <p>
 * 题目: 给定一个二叉树，按照Zigzag顺序层次遍历二叉树。顺序如下：
 *
 * <pre>
 *                3                  ->   3
 *         9             20          ->   20, 9
 *      n     n     15      7        ->   15, 7
 * </pre>
 * <p>
 * 思路: 使用队列的层次遍历，由于题目需要以行输出，所以建议使用两个队列，一个是当前正在访问的队列，一个是给下次需要遍历的队列
 * <p>
 * 队列的遍历方式一定是从尾部先遍历，即后放入的先遍历，这样才能保证顺序性。
 *
 * 往下次遍历的队列中添加顺序要注意：
 * <p>
 * 定义一个leftToRight的变量，初始值为true，代表的是从左往右的遍历。
 * <p>
 * 如果leftToRight=true，那么访问当前队列的元素，添加到下次队列中的元素是先左节点，再右节点。
 * <p>
 * 如果leftToRight=false，那么访问当前队列的元素，添加到下次队列中的元素先右节点，再左节点。
 * <p>
 * 类似题型: Populating Next Right Pointers in Each Node II
 * <p>
 * Average of Levels in Binary Tree
 * <p>
 * Lowest Common Ancestor of Deepest Leaves
 *
 * @author thinking_fioa 2021/10/15
 */
public class Leetcode103 {

  /**
   * faster than 80.85%, less than 69.16%
   */
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    if (root == null) {
      return new ArrayList<>();
    }

    List<List<Integer>> result = new ArrayList<>();
    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.add(root);
    boolean leftToRight = true;
    while (!deque.isEmpty()) {
      List<Integer> single = new ArrayList<>();
      Deque<TreeNode> next = new ArrayDeque<>();
      while (!deque.isEmpty()) {
        TreeNode n;
        if (leftToRight) {
          n = deque.pollLast();
          if (n.left != null) {
            next.add(n.left);
          }
          if (n.right != null) {
            next.add(n.right);
          }
        } else {
          n = deque.pollLast();
          if (n.right != null) {
            next.add(n.right);
          }
          if (n.left != null) {
            next.add(n.left);
          }
        }
        single.add(n.val);
      }
      leftToRight = !leftToRight;
      deque = next;
      result.add(single);
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
