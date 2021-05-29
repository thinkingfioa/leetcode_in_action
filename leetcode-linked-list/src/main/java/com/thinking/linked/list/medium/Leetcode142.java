package com.thinking.linked.list.medium;

/**
 * Title: Linked List Cycle II
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 方法一：快慢指针，fast指针一次走2步，slow指针一次走1步。
 * <p>
 * 方法二：利用HashMap存放已经遍历过的节点。如果题目要求是使用O(1)空间复杂度，则不适用
 * <p>
 * 类似题型: Linked List Cycle
 * <p>
 * Find the Duplicate Number
 *
 * @author thinking_fioa 2021/5/26
 */
public class Leetcode142 {

  /**
   * fast 100.00%，less than 92.83%
   */
  public ListNode detectCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (true) {
      if (slow == null || fast == null || fast.next == null) {
        return null;
      }
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }
    ListNode other = head;
    while (other != slow) {
      other = other.next;
      slow = slow.next;
    }
    return other;
  }

  class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }
}
