package com.thinking.tree.medium;

/**
 * Title: Construct Binary Tree from Preorder and Inorder Traversal
 * <p>
 * 题目: 给定二叉树的先序遍历和中序遍历结果，构建出一个二叉树
 * <p>
 * 思路: 采用递归的思路，先序遍历当前访问节点preorder[i]应该是访问的根节点，创建出一个new TreeNode(preorder[i])
 * <p>
 * 然后在中序遍历的结果中找到preorder[i]数，将中序遍历数组一分为二，左边用于构建二叉树左节点，右边用于构建二叉树的右节点
 * <p>
 * 假设左边二叉树左节点总数为leftCount，我们可以从先序遍历找到preorder[i+1, i+leftCount]截取。依次递归，则可构建出。
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
