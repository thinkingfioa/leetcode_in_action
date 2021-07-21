package com.thinking.linked.list.medium;

/**
 * Title: Remove Nth Node From End of List
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Swapping Nodes in a Linked List
 *
 * @author thinking_fioa 2021/7/20
 */
public class Leetcode19 {

  /**
   * faster than 100% less than 62.38%
   *
   * @param head
   * @param n
   * @return
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return head;
    }

    ListNode customHead = new ListNode();
    customHead.next = head;
    ListNode first = customHead;
    ListNode second = customHead;
    for (int i = 0; second != null && i <= n; i++) {
      second = second.next;
    }
    while (second != null) {
      first = first.next;
      second = second.next;
    }
    first.next = first.next.next;
    return customHead.next;
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
