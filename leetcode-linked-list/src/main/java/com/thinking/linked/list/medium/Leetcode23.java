package com.thinking.linked.list.medium;

/**
 * Title: Merge k Sorted Lists
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/6/5
 */
public class Leetcode23 {

  /**
   * faster than 88.61%，ess than 9.45%
   */
  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) {
      return null;
    }

    return mergeKLists(lists, 0, lists.length - 1);
  }

  private ListNode mergeKLists(ListNode[] lists, int leftIndex, int rightIndex) {
    if (leftIndex == rightIndex) {
      return lists[leftIndex];
    }
    if (leftIndex > rightIndex) {
      return null;
    }

    int midIndex = (leftIndex + rightIndex) / 2;
    ListNode left = mergeKLists(lists, leftIndex, midIndex);
    ListNode right = mergeKLists(lists, midIndex + 1, rightIndex);
    return mergeTwoLists(left, right);
  }

  private ListNode mergeTwoLists(ListNode left, ListNode right) {
    if (right == null) {
      return left;
    }
    ListNode head = null;
    ListNode move = null;
    while (left != null || right != null) {
      ListNode tmp;
      if (left != null && right != null) {
        if (left.val < right.val) {
          tmp = left;
          left = left.next;
        } else {
          tmp = right;
          right = right.next;
        }
      } else if (left != null) {
        tmp = left;
        left = left.next;
      } else {
        tmp = right;
        right = right.next;
      }
      if (head == null) {
        head = tmp;
        move = tmp;
      } else {
        move.next = tmp;
        move = move.next;
      }
    }
    return head;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
