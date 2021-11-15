package com.thinking.linked.list.hard;

/**
 * Title: Reverse Nodes in k-Group
 * <p>
 * 题目: 给定一个链表head和一个数字k，要求从链表头开始，每k个节点反转一次，如果链表剩余节点数不足k个，则无需反转
 *
 * <pre>
 * input     1 -> 2 -> 3 -> 4 -> 5; k 2
 * output    2 -> 1 -> 4 -> 3 -> 5
 * </pre>
 * <p>
 * 思路: 第一步，先计算链表的长度len；并头插一个虚拟节点
 * <p>
 * 第二步，len/k得出需要反转的次数，随后进行for循环。
 * <p>
 * 第三步，使用头插法，逆转节点。
 * <p>
 * 类似题型: Swap Nodes in Pairs
 * <p>
 * Swapping Nodes in a Linked List
 *
 * @author thinking_fioa 2021/10/13
 */
public class Leetcode25 {

  /**
   * faster than 40.76%， less than 22.31%
   */
  public ListNode reverseKGroup(ListNode head, int k) {
    int len = 0;
    ListNode virtualNode = new ListNode();
    virtualNode.next = head;
    ListNode move = virtualNode.next;
    while (move != null) {
      len++;
      move = move.next;
    }

    int loop = len / k;
    ListNode backPreNode = virtualNode;
    for (int i = 0; i < loop; i++) {
      move = backPreNode.next;
      for (int j = 1; j < k; j++) {
        ListNode p = move.next;
        move.next = p.next;
        p.next = backPreNode.next;
        backPreNode.next = p;
      }
      backPreNode = move;
    }
    return virtualNode.next;
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
