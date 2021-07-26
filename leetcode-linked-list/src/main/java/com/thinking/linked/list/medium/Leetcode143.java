package com.thinking.linked.list.medium;

/**
 * Title: Reorder List
 * <p>
 * 题目: 给定一个链表: L1->L2->L3->L4->...->Ln，重新对该链表排序。变成: L1->Ln->L2->Ln-1->L3->...
 * <p>
 * 思路: 第一步：将链表分为两部分，假设链表的总节点数为num，第一个链表节点数为(n+1)/2，第二链表节点数为n-(n+1)/2
 * <p>
 * 第二步：反转第二个链表
 * <p>
 * 第三步合并第一个链表和反转后的第二个链表，则可得到结果
 * <p>
 * 类似题型: Min Stack
 * <p>
 * Move Zeroes
 * <p>
 * Pancake Sorting
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
