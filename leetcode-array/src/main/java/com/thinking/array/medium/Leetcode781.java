package com.thinking.array.medium;


import com.thinking.common.ConsoleOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: Rabbits in Forest
 * <p>
 * 题目:
 * <p>
 * 思路:
 * <p>
 * 类似题型: Most Frequent Subtree Sum
 * <p>
 * Array of Doubled Pairs
 * <p>
 * Split a String in Balanced Strings
 *
 * @author thinking_fioa 2021/8/18
 */
public class Leetcode781 {

  /**
   * faster than 83.78%， less than 34.75%
   */
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> mark = new HashMap<>();
    int sum = 0;
    for (int i = 0; i < answers.length; i++) {
      int key = answers[i];
      if (key != 0) {
        Integer value = mark.get(key);
        if (null != value) {
          if (value > 1) {
            mark.put(key, value - 1);
          } else {
            mark.remove(key);
          }
        } else {
          mark.put(key, key);
          sum += key + 1;
        }
      } else {
        sum++;
      }
    }

    return sum;
  }

  public static void main(String[] args) {
    // Output 5
//    int[] answers = {1, 1, 2};
    // Output 5
    int[] answers = {0, 0, 1, 1, 1};

    Leetcode781 leetcode781 = new Leetcode781();
    ConsoleOutput.printf(leetcode781.numRabbits(answers));
  }
}
