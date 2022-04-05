package com.thinking.linked.list.medium;

/**
 * Title: Odd Even Linked List
 * <p>
 * 题目: 给定一个链表，定义链表的第一个节点为奇节点，第二个节点为偶节点，第三个为奇节点，以此类推。
 * <p>
 * 要求将链表中奇节点排在前面，偶节点排在后面。且不要改变原来链表中的奇节点与偶节点的相对位置。空间复杂度为O(1)，
 * <p>
 * 时间复杂度为O(n)
 * <pre>
 *   input : 1 -> 2 -> 3 -> 4 -> 5
 *   output: 1 -> 3 -> 5 -> 2 -> 4
 * </pre>
 * <p>
 * 思路: 先定义两个起始节点，分别表示的是奇节点的起点和偶节点的起点。随后开始遍历整个链表，当整个链表遍历完后，
 * <p>
 * 再将奇节点和偶节点连接起来即可
 * <p>
 * 类似题型: Split Linked List in Parts
 *
 * @author vlin 2022/3/7
 */
public class Leetcode328 {

  /**
   * faster than 33.14%，less than 36.03%
   */
  public ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode evenNode = head.next;
    if (evenNode == null) {
      return head;
    }

    ListNode oddMove = head;
    ListNode evenMove = evenNode;
    ListNode move = evenMove.next;
    evenMove.next = null;
    int count = 0;
    while (move != null) {
      count++;
      ListNode nextLoop = move.next;
      if (count % 2 == 1) {
        oddMove.next = move;
        oddMove = oddMove.next;
        oddMove.next = null;
      } else {
        evenMove.next = move;
        evenMove = evenMove.next;
        evenMove.next = null;
      }
      move = nextLoop;
    }
    oddMove.next = evenNode;
    return head;
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
