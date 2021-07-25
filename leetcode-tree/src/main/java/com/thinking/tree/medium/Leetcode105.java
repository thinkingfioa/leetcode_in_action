package com.thinking.tree.medium;

/**
 * Title: Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author thinking_fioa 2021/7/25
 */
public class Leetcode105 {

  /**
   * faster than 62.10%, less than 80.58%
   */
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(preorder, 0, preorder.length - 1,
        inorder, 0, inorder.length - 1);
  }

  private TreeNode buildTree(int[] preorder, int pBeginIndex, int pEndIndex,
      int[] inorder, int iBeginIndex, int iEndIndex) {
    if (pBeginIndex > pEndIndex) {
      return null;
    }
    TreeNode p = new TreeNode(preorder[pBeginIndex]);
    int findIndexInOrder = findIndexInOrder(inorder, iBeginIndex, iEndIndex, preorder[pBeginIndex]);
    int leafCount = findIndexInOrder - iBeginIndex;
    p.left = buildTree(preorder, pBeginIndex + 1, pBeginIndex + leafCount, inorder,
        iBeginIndex, findIndexInOrder - 1);
    p.right = buildTree(preorder, pBeginIndex + leafCount + 1, pEndIndex, inorder,
        findIndexInOrder + 1, iEndIndex);
    return p;
  }

  private int findIndexInOrder(int[] inorder, int iBeginIndex, int iEndIndex, int num) {
    for (int i = iBeginIndex; i <= iEndIndex; i++) {
      if (inorder[i] == num) {
        return i;
      }
    }
    return 0;
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
