package com.thinking.linked.list.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Title: Copy List with Random Pointer
 * <p>
 * 题目: 给一个链表head，每个Node由元素: int val、Node next和Node random三个元素组成。next指向下一个节点
 * <p>
 * random随机指向链表中的某个节点。
 * <p>
 * 请写一个深度拷贝构造函数，构造一个新的链表返回
 * <p>
 * 思路:
 * <p>
 * 类似题型:
 *
 * @author vlin 2021/12/16
 */
public class Leetcode138 {

  /**
   * faster then 100.00%，less than 36.29%
   */
  public Node copyRandomList(Node head) {
    Node virtualNode = new Node(-1);
    virtualNode.next = head;
    Node move = virtualNode.next;
    Map<Node, Integer> posOldMap = new HashMap<>(1000);
    Map<Integer, Node> posNewMap = new HashMap<>(1000);
    Node virtualResultNode = new Node(-1);
    int index = 0;
    Node moveResult = virtualResultNode;
    while (move != null) {
      index++;
      Node newNode = new Node(move.val);
      moveResult.next = newNode;
      posOldMap.put(move, index);
      posNewMap.put(index, newNode);
      move = move.next;
      moveResult = moveResult.next;
    }
    move = virtualNode.next;
    moveResult = virtualResultNode.next;
    while (move != null) {
      if (move.random != null) {
        Integer posNum = posOldMap.get(move.random);
        moveResult.random = posNewMap.get(posNum);
      }
      moveResult = moveResult.next;
      move = move.next;
    }

    return virtualResultNode.next;
  }

  private static class Node {

    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
