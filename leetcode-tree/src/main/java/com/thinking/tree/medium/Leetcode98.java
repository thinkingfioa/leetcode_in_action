package com.thinking.tree.medium;


import java.util.ArrayList;
import java.util.List;

/**
 * Title: Validate Binary Search Tree
 * <p>
 * 题目: 给一个二叉树，判断二叉树是否是BST树，即二叉搜索树(binary search tree)，一个合理的BST树条件是:
 * <p>
 * 1. 当前节点的左子树所有的节点值小于当前节点
 * <p>
 * 2. 当前节点的右子树所有的节点值大于当前节点
 * <p>
 * 3. 当前节点的左子树和右子树都是BST树
 * <p>
 * 难点与误区: 难点在于孩子节点与祖父的大小比对。输入用例: [5,4,6,null,null,3,7]
 * <pre>
 *              5
 *         4         6
 *    null  null   3    7
 * </pre>
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 * <p>
 * Time Needed to Inform All Employees
 *
 * @author thinking_fioa 2021/10/8
 */
public class Leetcode98 {

  /**
   * @param root
   * @return
   */
  public boolean isValidBST(TreeNode root) {
    if (root == null) {
      return true;
    }
    List<TreeNode> list = new ArrayList<>();
    inorder(root, list);
    return checkBST(list);
  }

  private void inorder(TreeNode root, List<TreeNode> list) {
    if (root == null) {
      return;
    }
    // 采用中序递归遍历
    inorder(root.left, list);
    list.add(root);
    inorder(root.right, list);
  }

  private boolean checkBST(List<TreeNode> list) {
    int preVal = list.get(0).val;
    int size = list.size();
    for (int i = 1; i < size; i++) {
      if (preVal >= list.get(i).val) {
        return false;
      } else {
        preVal = list.get(i).val;
      }
    }
    return true;
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
