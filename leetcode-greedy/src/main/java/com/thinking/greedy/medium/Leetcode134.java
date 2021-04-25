package com.thinking.greedy.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Gas Station
 * <p>
 * 题目: 给两个一维数组gas[]和cost[]，下标为gas[i]和cost[i]分别代表第i个站点可补充的汽油数，cost[i]代表从i站点到i+1站点
 * <p>
 * 需要花费的汽油数。寻找满足条件的i站点，使得从i站点触发，能走一圈回到i站点。如果找不到返回-1
 * <p>
 * 思路: 对于第i个站点，定义surplusArray[i]=gas[i]+cost[i]，surplusArray[i]>0表示通过第i个能增加汽油数，
 * <p>
 * surplusArray[i]<=0表示通过第i个将减少汽油数。
 * <p>
 * 第一：先把不能走一圈的排除了。如果数组surplusArray求和小于0，说明找不到。
 * <p>
 * 第二：如果一定能走一圈，那么题目转化为寻找i站点，从i站点开始，到数组surplusArray数组尾部，求和大于等于0。
 * <p>
 * 类似题型: Employee Free Time
 * <p>
 * Advantage Shuffle
 * <p>
 * Minimum Operations to Reduce X to Zero
 *
 * @author thinking_fioa 2021/3/16
 */
public class Leetcode134 {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int len = gas.length;
    int[] surplusArray = new int[len];
    for (int i = 0; i < surplusArray.length; i++) {
      surplusArray[i] = gas[i] - cost[i];
    }

    int sum = 0;
    for (int i = 0; i < surplusArray.length; i++) {
      sum += surplusArray[i];
    }
    if (sum < 0) {
      return -1;
    }
    int startIndex = -1;
    int greedySum = 0;
    for (int i = 0; i < surplusArray.length; i++) {
      if (greedySum <= 0 && surplusArray[i] < 0) {
        startIndex = -1;
        greedySum = 0;
      } else if (greedySum <= 0 && surplusArray[i] >= 0) {
        startIndex = i;
        greedySum = 0;
        greedySum += surplusArray[i];
      } else {
        greedySum += surplusArray[i];
      }
    }
    return startIndex;
  }

  public static void main(String[] args) {
    // Output 3
//    int[] gas = {1, 2, 3, 4, 5};
//    int[] cost = {3, 4, 5, 1, 2};
    // Output -1
//    int[] gas = {2, 3, 4};
//    int[] cost = {3, 4, 3};
    // Output 0
    int[] gas = {2};
    int[] cost = {2};
    Leetcode134 leetcode134 = new Leetcode134();
    ConsoleOutput.printf(leetcode134.canCompleteCircuit(gas, cost));
  }
}
