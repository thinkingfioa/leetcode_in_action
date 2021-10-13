package com.thinking.array.hard;


import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

/**
 * Title: Sliding Window Maximum
 * <p>
 * 题目: 给一个数组nums[]和窗口k，依据窗口k依次在数组nums上滑动，求出每次窗口内的最大数num。比如以下用例
 * <pre>
 *   Window position                Max
 *  ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * </pre>
 * <p>
 * 思路1: 这是一道滑动窗口题，查找窗口中的最大数。当我们访问到nums[i]时，前面nums[k]<nums[i](k<i)的所有数都失去了意义。
 * <p>
 * 思考使用双端队列，队首放的是目前访问的最大值，每访问一个nums[i]数时，尝试添加到队尾
 * <p>
 * 添加的条件：检查目前队尾数nums[k]是否小于nums[i]，如果是，则直接弹出队尾元素nums[k]，循环检查，直到不大于nums[i]
 * <p>
 * 所以，我们将得到一个[队尾,队首]是递增的一个双端队列。
 * <p>
 * 难点：滑动窗口的大小是k，我们需要判断队首元素是否已经不在窗口中，考虑将数组下标放到双端队列中，
 * <p>
 * 通过deque.peekFirst()+k<=i来检测是否队首元素已经超过窗口限制，将其移出双端队列中
 * <p>
 * 思路2: 使用一个有序的TreeMap，按照key的逆序排列。滑动窗口每次往右移动一位，将从TreeMap剔除nums[left]，并添加nums[right]
 * <p>
 * 滑动窗口每次往右移动一位，将出现一个结果，保存到result结果集中。
 * <p>
 * 类似题型: Min Stack
 * <p>
 * Longest Substring with At Most Two Distinct Characters
 * <p>
 * Paint House II
 * <p>
 * Jump Game VI
 *
 * @author thinking_fioa 2021/10/9
 */
public class Leetcode239 {

  /**
   * faster than 56.99%, less than 70.65%
   */
  public int[] maxSlidingWindow(int[] nums, int k) {
    int index = 0;
    int[] result = new int[nums.length - k + 1];
    // Queue中存放的数组下标
    Deque<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < nums.length; i++) {
      if (!queue.isEmpty() && (queue.peekFirst() + k <= i)) {
        queue.removeFirst();
      }
      while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
        queue.removeLast();
      }
      queue.add(i);
      if (i + 1 >= k) {
        result[index++] = nums[queue.peekFirst()];
      }
    }
    return result;
  }

  /**
   * faster than 5.02%, less than 50.60%
   */
  public int[] maxSlidingWindow2(int[] nums, int k) {
    TreeMap<Integer, Integer> visited = new TreeMap<>((Integer o1, Integer o2) -> o2 - o1);
    int left = 0;
    int right = 0;
    for (; right < k; right++) {
      visited.putIfAbsent(nums[right], 0);
      visited.computeIfPresent(nums[right], (key, value) -> value + 1);
    }
    int index = 0;
    int[] result = new int[nums.length - k + 1];
    result[index++] = visited.firstKey();
    for (; right < nums.length; right++) {
      Integer newValue = visited.computeIfPresent(nums[left], (key, value) -> value - 1);
      if (newValue == 0) {
        visited.remove(nums[left]);
      }
      left++;
      visited.putIfAbsent(nums[right], 0);
      visited.computeIfPresent(nums[right], (key, value) -> value + 1);
      result[index++] = visited.firstKey();
    }
    return result;
  }

  public static void main(String[] args) {
    // Output [3,3,5,5,6,7]
//    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//    int k = 3;

    // Output [3,3,2,5]
    int[] nums = {1, 3, 1, 2, 0, 5};
    int k = 3;

    Leetcode239 leetcode239 = new Leetcode239();
    ConsoleOutput.printf(leetcode239.maxSlidingWindow(nums, k));
  }
}
