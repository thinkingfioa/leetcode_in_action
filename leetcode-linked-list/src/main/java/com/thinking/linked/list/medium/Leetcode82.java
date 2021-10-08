package com.thinking.linked.list.medium;

/**
 * Title: Remove Duplicates from Sorted List II
 * <p>
 * 题目: 给定一个有序的链表，删除链表中重复数字的节点。
 * <p>
 * 比如输入是: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
 * <p>
 * 输出是: 1 -> 2 -> 5
 * <p>
 * 思路: 所有的链表问题，建议都先加上一个虚拟节点头，避免头节点重复时，需要特殊处理
 * <p>
 * 定义三个指针：p1, p2, p3。p1是第一个不重复的位置，p2和p3分别是重复数字的头和尾部节点的后一个节点。
 *
 * 当发现p2=p3时，会让p3一直往后移动，直到p3!=p2或者到链表末尾。
 * <p>
 * 类似题型: Remove Duplicates from Sorted List
 * <p>
 * Remove Duplicates From an Unsorted Linked List
 *
 * @author thinking_fioa 2021/8/8
 */
public class Leetcode82 {

  /**
   * input 1，2，3，3，4，4，5
   * <p>
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
