package com.thinking.tree.medium;

/**
 * Title: Delete Node in a BST
 * <p>
 * 题目: 给定一个BST（二叉搜索树），删除BST树中的某个节点。
 * <p>
 * 思路:
 * <pre>
 *   删除一个BST中的节点，当前节点分为四种情况，操作逻辑不同：
 *   第一种：当前节点没有孩子节点。答：可直接删除
 *   第二种：当前节点有左孩子，没有右孩子。答：删除后，由左孩子接替当前节点
 *   第三种：当前节点没有左孩子，有右孩子。答：删除后，由右孩子接替当前节点
 *   第四种：当前节点有左孩子和右孩子。答：可由左子树的最大节点和右子树的最小节点赋值接替
 * </pre>
 * <p>
 * 类似题型: Split BST
 *
 * @author vlin 2022/4/2
 */
public class Leetcode450 {

  /**
   * faster than 100.00%，less than 90.39%
   */
  public TreeNode deleteNode(TreeNode root, int key) {
    if (!contain(root, key)) {
      return root;
    }
    if (root.val == key) {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      } else {
        TreeNode succsor = findMin(root.right);
        succsor.right = deleteMinNode(root.right);
        succsor.left = root.left;
        return succsor;
      }
    } else if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else {
      root.right = deleteNode(root.right, key);
    }
    return root;
  }

  private TreeNode findMin(TreeNode t) {
    TreeNode move = t;
    while (move != null) {
      if (move.left == null) {
        return move;
      }
      move = move.left;
    }
    return move;
  }

  private TreeNode deleteMinNode(TreeNode t) {
    if (t.left == null) {
      return t.right;
    }
    t.left = deleteMinNode(t.left);
    return t;
  }

  private boolean contain(TreeNode t, int key) {
    if (t == null) {
      return false;
    }
    if (t.val == key) {
      return true;
    }
    if (contain(t.left, key)) {
      return true;
    }
    return contain(t.right, key);
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
