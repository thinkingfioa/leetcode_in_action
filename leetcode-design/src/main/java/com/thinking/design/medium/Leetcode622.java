package com.thinking.design.medium;

/**
 * Title: Design Circular Queue
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Design Circular Deque
 * <p>
 * Design Front Middle Back Queue
 *
 * @author thinking_fioa 2021/7/25
 */
public class Leetcode622 {

  /**
   * faster than 97.71%， less than 71.62%
   */
  public static class MyCircularQueue {

    private int[] ringBuffer;
    private int size;
    private int head;
    private int tail;

    public MyCircularQueue(int k) {
      ringBuffer = new int[k + 1];
      size = k + 1;
      head = 0;
      tail = 0;
    }

    public boolean enQueue(int value) {
      if (isFull()) {
        return false;
      }
      tail = modSize(tail + 1);
      ringBuffer[tail] = value;
      return true;
    }

    public boolean deQueue() {
      if (isEmpty()) {
        return false;
      }
      head = modSize(head + 1);
      return true;
    }

    public int Front() {
      if (isEmpty()) {
        return -1;
      }
      return ringBuffer[modSize(head + 1)];
    }

    public int Rear() {
      if (isEmpty()) {
        return -1;
      }

      return ringBuffer[tail];
    }

    public boolean isEmpty() {
      return head == tail;
    }

    public boolean isFull() {
      return modSize(tail + 1) == head;
    }

    private int modSize(int num) {
      return num % size;
    }
  }
}
