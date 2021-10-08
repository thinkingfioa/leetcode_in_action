package com.thinking.array.medium;


import com.thinking.common.ConsoleOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: Rabbits in Forest
 * <p>
 * 题目: 森林中有一群兔子，兔子有不同的颜色，n个兔子都告知说有多少的兔子与自己颜色相同，组成了一维数组answers[]
 * <p>
 * 数组answers[]中第i个节点answers[i]的值代表的是下标索引i的兔子告知与自己颜色相同的兔子数（不包括自己）
 * <p>
 * 求：森林中最小有多少个兔子？
 * <p>
 * 难点： 1. 注意answers[i]可能为0
 * <p>
 * 2. 可能出现t个兔子报answers[i]=m，但是t>m，那么特殊处理。比如输入用例：0, 0, 1, 1, 1。输出结果应该为6
 * <p>
 * 思路: 第1步：判断answers[i]是否为0，如果是，那兔子数num肯定需要+1
 * <p>
 * 第2步：构建一个Map<Integer, Integer>, key是输出answers[i]，value剩余数。用于解决申报重复数。
 * <p>
 * 第2.1步：检查Map<Integer, Integer>是否找到，找不到num+key+1，并放入；找到实现num+1，则将value-1
 *
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
    // Output 6
    int[] answers = {0, 0, 1, 1, 1};

    Leetcode781 leetcode781 = new Leetcode781();
    ConsoleOutput.printf(leetcode781.numRabbits(answers));
  }
}
