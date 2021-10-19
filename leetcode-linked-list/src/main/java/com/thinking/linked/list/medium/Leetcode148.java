package com.thinking.linked.list.medium;

/**
 * Title: Reorder List
 * <p>
 * 题目: 给定一个链表，请排序链表，要求时间时间复杂度为O(n*logn)和空间复杂度为O(1)
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/10/19
 */
public class Leetcode148 {

  /**
   * faster than 41.97%, less than 25.29%
   */
  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode half = findHalf(head);
    ListNode left = sortList(head);
    ListNode right = sortList(half);
    return mergeListNode(left, right);
  }

  public ListNode findHalf(ListNode l1) {
    ListNode p1 = l1;
    ListNode p2 = l1;
    while (p2 != null && p2.next != null && p2.next.next != null) {
      p1 = p1.next;
      p2 = p2.next.next;
    }
    ListNode backUp = p1.next;
    p1.next = null;
    return backUp;
  }

  public ListNode mergeListNode(ListNode l1, ListNode l2) {
    ListNode vir = new ListNode();
    ListNode p1 = l1;
    ListNode p2 = l2;
    ListNode move = vir;
    while (p1 != null && p2 != null) {
      if (p1.val < p2.val) {
        move.next = p1;
        p1 = p1.next;
      } else {
        move.next = p2;
        p2 = p2.next;
      }
      move = move.next;
    }
    if (p1 != null) {
      move.next = p1;
    } else {
      move.next = p2;
    }
    return vir.next;
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
