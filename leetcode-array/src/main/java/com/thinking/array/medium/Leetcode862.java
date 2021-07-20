package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Shortest Subarray with Sum at Least K
 * <p>
 * 题目: 给定一个数组nums和一个k值。求数组中最少长度的连续子数组求和大于等于k的子数组长度。
 * <p>
 * 思路: 子数组求和的问题，我们会将数组len个元素的nums数组，转成成len+1个sumNums数组。sumNums[i]代表的是原数组[0,i-1]的下标的和。
 * <p>
 * 接下来最简单的思路就是暴力，遍历求和后的数组sumNums，分别计算步长Gap=1, 2, ..., len的差值大于等于k。
 * <p>
 * 遗憾的是暴力方法超时，我们利用双端队列来进行剪枝操作：
 * <p>
 * 第一：假设你遍历到sumNums[i]的元素，与队列的队首元素计算是否差值大于等于k，如果符合，弹出队列队首元素，
 * <p>
 * 因为不可能有与队首元素最为被减数 更短的步长出现了。
 * <p>
 * 第二：将遍历的sumNums[i]添加到队列尾部，先检查队尾元素是否比nums[i]大，如果大于可以直接移除队尾元素，
 * <p>
 * 假设队尾元素如果是最终的解，那么nums[i]作为求和起点肯定更优，因为nums[i]比队尾元素小 && 子数组长度更小
 * <p>
 * 类似题型: Minimum Index Sum of Two Lists
 * <p>
 * Maximum Sum Obtained of Any Permutation
 * <p>
 * Widest Vertical Area Between Two Points Containing No Points
 *
 * @author thinking_fioa 2021/7/11
 */
public class Leetcode862 {

  /**
   * faster than 45.58%，less than 67.81%
   */
  public int shortestSubarray(int[] nums, int k) {
    int[] sumArray = new int[nums.length + 1];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      sumArray[i + 1] = sum;
    }
    int result = Integer.MAX_VALUE;
    Deque<Integer> queue = new ArrayDeque<>();
    queue.add(0);
    for (int i = 1; i < sumArray.length; i++) {
      while (!queue.isEmpty() && (sumArray[i] - sumArray[queue.getFirst()]) >= k) {
        result = Math.min(i - queue.getFirst(), result);
        queue.removeFirst();
      }
      while (!queue.isEmpty() && (sumArray[i] <= sumArray[queue.getLast()])) {
        queue.removeLast();
      }
      queue.add(i);
    }
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  public static void main(String[] args) {
    // Output 3
//    int[] nums = {2, -1, 2};
//    int k = 3;
    // Output 1
    int[] nums = {77, 19, 35, 10, -14};
    int k = 19;
    Leetcode862 leetcode862 = new Leetcode862();
    ConsoleOutput.printf(leetcode862.shortestSubarray(nums, k));
  }
}
