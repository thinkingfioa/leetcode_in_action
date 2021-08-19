package com.thinking.linked.list.medium;

/**
 * Title: Remove Duplicates from Sorted List II
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Remove Duplicates from Sorted List
 * <p>
 * Remove Duplicates From an Unsorted Linked List
 *
 * @author thinking_fioa 2021/8/8
 */
public class Leetcode82 {

  /**
   * faster than 100.00%，less than 21.12%
   */
  public ListNode deleteDuplicates(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode virHead = new ListNode(-1);
    virHead.next = head;
    ListNode p1 = virHead;
    ListNode p2 = p1.next;
    ListNode p3 = p2.next;
    while (null != p3) {
      if (p2.val == p3.val) {
        while (null != p3 && p2.val == p3.val) {
          p3 = p3.next;
        }
        p1.next = p3;
        p2 = p3;
        if (null != p3) {
          p3 = p3.next;
        }
      } else {
        p1 = p2;
        p2 = p3;
        p3 = p3.next;
      }
    }
    return virHead.next;
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
