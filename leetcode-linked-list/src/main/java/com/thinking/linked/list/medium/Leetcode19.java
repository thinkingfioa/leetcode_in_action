package com.thinking.linked.list.medium;

/**
 * Title: Remove Nth Node From End of List
 * <p>
 * 题目: 给定一个链表，移除末尾第N个元素
 * <p>
 * 思路: 思路较为简单，使用两个指针：first和second，让first先移动N个元素，随后first和second同时移动，每次移动一步
 * <p>
 * 当first移动到链表的末尾时，second则指向了第N个元素，即可删除
 * <p>
 * 类似题型: Swapping Nodes in a Linked List
 *
 * @author thinking_fioa 2021/7/20
 */
public class Leetcode19 {

  /**
   * faster than 100% less than 62.38%
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
