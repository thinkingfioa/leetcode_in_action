package com.thinking.linked.list.medium;

/**
 * Title: Reverse Linked List II
 * <p>
 * 题目: 给定一个链表头head，和left、right两个数组，要求反转链表中第left至第right之间的所有链表元素。
 * <p>
 * 思路: 使用头插法交换第left至第right之间的元素。需要特殊考虑亮点:
 * <p>
 * 1. 使用头插法，如果left=1，那么第一个元素就是头。需要特殊处理。通常我们可以构建一个虚拟的头来避免这个特殊场景
 * <p>
 * 2. 每次头插入法，都需要保留注：ListNode tmp =move.next，需要赋值给插入的头的next域。
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
