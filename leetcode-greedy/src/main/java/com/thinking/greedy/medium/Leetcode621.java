package com.thinking.greedy.medium;

import com.thinking.common.ConsoleOutput;
import java.util.Arrays;

/**
 * Title: Task Scheduler
 * <p>
 * 题目: 给定一个字符数组tasks，字符数组tasks中填写[A-Z]的大写字母，每个字母代表一个任务。再给一个数字n，表示相同的任务
 * <p>
 * 必须中间间隔n个CPU的调度，如果不满足需要添加一个空闲的时间片。求调度完字符数组tasks的所有任务，需要的CPU时间片个数。
 * <p>
 * 思路: 题目应该最关心的是重复任务个数最多的任务，因为如果重复任务最多的任务满足了n的要求，其他任务肯定能满足。
 * <p>
 * 假设字符数组中tasks中重复个数最多的任务是'A'，给定的数字n=5。意味着每两个'A'之间都要间隔5个其他任务或者是空时间片。
 * <p>
 * 假设最坏的情况全是'A'，意味着要插入idleNum=(numA-1)*n个闲置的CPU，那么总共需要的CPU时间片给数为：tasks.length+idleNum。
 * <p>
 * 假设除了'A'还有其他任务'B'，我们应该优先将其他任务'B'填入到闲置的位置，有如下两种情况：
 * <p>
 * 1. 如果最终所有的闲置位置都被填满了，意味着不需要补充闲置的时间片，那么总共需要的CPU时间片数为：tasks.length。
 * <p>
 * 2. 如果最终仍有闲置位置，意味着需要补充闲置的时间片，那么总共需要的CPU时间片数为：tasks.length+仍需补充idleNum。
 * <p>
 * 类似题型: Reorganize String
 *
 * @author thinking_fioa 2021/7/11
 */
public class Leetcode621 {

  /**
   * faster than 99.51%, less than 57.22%
   */
  public int leastInterval(char[] tasks, int n) {
    int[] letterArray = new int[26];
    for (char task : tasks) {
      letterArray[task - 'A']++;
    }
    Arrays.sort(letterArray);
    int needIdea = (letterArray[25] - 1) * n;
    for (int move = 24; move >= 0 && letterArray[move] > 0; move--) {
      needIdea -= Math.min(letterArray[25] - 1, letterArray[move]);
    }
    if (needIdea > 0) {
      return tasks.length + needIdea;
    } else {
      return tasks.length;
    }
  }

  public static void main(String[] args) {
    // output 8
    char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
//    char[] tasks = {'A', 'A', 'A', 'B', 'B'};
    int n = 2;
    Leetcode621 leetcode621 = new Leetcode621();
    ConsoleOutput.printf(leetcode621.leastInterval(tasks, n));
  }
}
