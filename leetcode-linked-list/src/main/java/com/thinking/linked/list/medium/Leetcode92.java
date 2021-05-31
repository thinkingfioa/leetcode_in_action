package com.thinking.linked.list.medium;

/**
 * Title: Reverse Linked List II
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:  Reverse Linked List
 *
 * @author thinking_fioa 2021/5/31
 */
public class Leetcode92 {

  /**
   * faster than 100.00%, less than 5.02%
   */
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (left == right) {
      return head;
    }
    ListNode virHead = new ListNode(0, head);
    ListNode move = virHead;
    for (int i = 1; i < left; i++) {
      move = move.next;
    }
    ListNode secondM = move.next;
    // 头插法
    for (int i = left; i < right; i++) {
      ListNode tmp = move.next;
      move.next = secondM.next;
      secondM.next = move.next.next;
      move.next.next = tmp;
    }
    return virHead.next;
  }

  private class ListNode {

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
