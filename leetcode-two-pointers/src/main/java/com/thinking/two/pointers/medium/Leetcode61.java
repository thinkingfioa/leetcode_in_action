package com.thinking.two.pointers.medium;

import com.thinking.ConsoleOutput;

/**
 * Title: Rotate List
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 思路2：快慢指针
 * <p>
 * 类似题型: Rotate Array
 * <p>
 * Split Linked List in Parts
 *
 * @author thinking_fioa 2021/4/6
 */
public class Leetcode61 {

  /**
   * <pre>
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   * </pre>
   */
  public ListNode rotateRight(ListNode head, int k) {
    int len = length(head);
    if (len == 0 || k == 0) {
      return head;
    }
    k = k % len;
    int surplus = len - k;
    ListNode cur = head;
    for (int i = 1; i < surplus; i++) {
      cur = cur.next;
    }
    ListNode tail = cur;
    while (tail.next != null) {
      tail = tail.next;
    }
    tail.next = head;
    head = cur.next;
    cur.next = null;
    return head;
  }

  private int length(ListNode head) {
    ListNode cur = head;
    int length = 0;
    while (cur != null) {
      length++;
      cur = cur.next;
    }
    return length;
  }

  public static void main(String[] args) {
    // Output [4,5,1,2,3]
//    int[] nums = {1, 2, 3, 4, 5};
//    int k = 2;
    // Outout [2,0,1]
    int[] nums = {0, 1, 2};
    int k = 4;
    Leetcode61 leetcode61 = new Leetcode61();
    print(leetcode61.rotateRight(createList(nums), k));
  }

  private static ListNode createList(int[] nums) {
    ListNode head = null;
    ListNode cur = null;
    for (int num : nums) {
      if (head == null) {
        head = new ListNode(num);
        cur = head;
        cur.next = null;
      } else {
        cur.next = new ListNode(num);
        cur = cur.next;
        cur.next = null;
      }
    }
    return head;
  }

  private static void print(ListNode head) {
    ListNode cur = head;
    while (cur != null) {
      ConsoleOutput.printf(cur.val + ",");
      cur = cur.next;
    }
  }

  /**
   * Definition for singly-linked list.
   */
  public static class ListNode {

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
