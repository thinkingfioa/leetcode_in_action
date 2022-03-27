package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Daily Temperatures
 * <p>
 * 题目: 给一个数组temperatures[]，代表每天的温度。计算一个数组answer[]，其中answer[i]=j表示第i+1天需要等待
 * <p>
 * j天后温度会更高
 * <p>
 * 思路：递减栈(栈底大于栈顶)。假设访问到temperatures[i]节点，题目要求的是从temperatures[i]开始，找到第一个比
 * <p>
 * temperatures[i]大的节点temperatures[j]，则answer[i]=j-i。
 * <p>
 * 所以，如果一个栈，栈中存放的是数组的下标，当前访问的节点temperatures[j]如果比栈顶的元素大，则栈顶出栈计算。
 * <p>
 * 思路2：利用两道for循环，题目刚好能直接过，时间复杂度高
 * <p>
 * 类似题型：Next Greater Element I
 * <p>
 * Online Stock Span
 *
 * @author vlin 2022/3/12
 */
public class Leetcode739 {

  /**
   * faster than 69.70%，less than 47.51%
   */
  public int[] dailyTemperatures(int[] temperatures) {
    Deque<Integer> queue = new ArrayDeque<>();
    int[] answer = new int[temperatures.length];
    for (int i = 0; i < temperatures.length; i++) {
      while (!queue.isEmpty() && temperatures[i] > temperatures[queue.peekLast()]) {
        int topIndex = queue.pollLast();
        answer[topIndex] = i - topIndex;
      }
      queue.addLast(i);
    }

    return answer;
  }

  /**
   * faster than 6.53%，less than 26.78%
   */
  public int[] dailyTemperatures2(int[] temperatures) {
    int[] answer = new int[temperatures.length];

    for (int i = 0; i + 1 < temperatures.length; i++) {
      if (temperatures[i] < temperatures[i + 1]) {
        answer[i] = 1;
      } else {
        for (int j = i + 1; j < temperatures.length; j++) {
          if (temperatures[i] < temperatures[j]) {
            answer[i] = j - i;
            break;
          }
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    // output [1,1,4,2,1,1,0,0]
    int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

    Leetcode739 leetcode739 = new Leetcode739();
    ConsoleOutput.printf(leetcode739.dailyTemperatures(temperatures));
  }
}
