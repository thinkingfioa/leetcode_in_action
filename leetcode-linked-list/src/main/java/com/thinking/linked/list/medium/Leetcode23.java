package com.thinking.linked.list.medium;

/**
 * Title: Merge k Sorted Lists
 * <p>
 * 题目: 给定k个升序的链表，将k个升序的链表合并成1个链表
 * <p>
 * 思路: 分而治至，将k个生序的链表先对半分，左半边的链表再对半分，右半边的链表再对半分。结束条件是只有一个链表或没有链表。
 * <p>
 * 将分开后的左半边合并后的结果和右半边合并后的结果通过链表合并算法合并出一个升序的链表，该链表作为返回值返回给上一层
 * <p>
 * 使用的和再进行合并。
 * <p>
 * 类似题型: Merge Two Sorted Lists
 * <p>
 * Ugly Number II
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
