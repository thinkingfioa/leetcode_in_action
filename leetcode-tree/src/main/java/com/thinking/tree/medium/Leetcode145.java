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
 * 思路: 二叉树的后序遍历是先遍历左节点，然后右节点，最后是中间节点。这样的顺序意味着中间节点需要先保存进队列，等左子树
 * <p>
 * 访问完，再访问右子树，题目难点在于什么时候输出中间节点。
 * <p>
 * 我们定义一个pre标记，表示上次访问的节点，如果pre节点是当前节点的右孩子或者左孩子，说明左右子树遍历完了，可以输出中间
 * <p>
 * 节点了。
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
