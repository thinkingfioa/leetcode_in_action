package com.thinking.linked.list.medium;

/**
 * Title: Reorder List
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/7/22
 */
public class Leetcode143 {

  /**
   * faster than 99.89%， less than 66.07%
   */
  public void reorderList(ListNode head) {
    int num = 0;
    ListNode move = head;
    while (move != null) {
      num++;
      move = move.next;
    }
    if (num <= 2) {
      return;
    }
    move = head;
    for (int i = 0; i < (num - 1) / 2; i++) {
      move = move.next;
    }
    ListNode backNext = move.next;
    move.next = null;
    move = backNext;
    ListNode second = new ListNode();
    second.next = null;
    // 反转链表
    while (move != null) {
      ListNode backupNext = move.next;
      move.next = second.next;
      second.next = move;
      move = backupNext;
    }
    ListNode p1 = head;
    ListNode p2 = second.next;
    for (int i = 0; i < num / 2; i++) {
      ListNode tmp1 = p1.next;
      ListNode tmp2 = p2.next;
      p1.next = p2;
      p2.next = tmp1;
      p1 = tmp1;
      p2 = tmp2;
    }
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
