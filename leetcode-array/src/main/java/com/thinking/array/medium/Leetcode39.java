package com.thinking.array.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 给定数组{2, 3, 6, 7} and target = 8，寻找所有相加结果.
 * <p>
 * 1. 第一种：初步思路，递归肯定能做. 但可能会超时. 该题目没有超时，且性能超过85%，可参考Go语言递归做法
 *
 * <pre>
 *   https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 * <p>
 * 2. 第二种：利用数组，分别计算[1, target]中的数字，性能不好
 *
 * @author thinking_fioa 11/09/2019
 */
public class Leetcode39 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    Set<List<Integer>> marked = new HashSet<>();
    Map<Integer, List<List<Integer>>> resultMap = new HashMap<>();

    for (int i = 0; i <= target; i++) {
      resultMap.put(i, new ArrayList<>());
    }
    for (int i = 0; i < candidates.length; i++) {
      List<Integer> result = new ArrayList<>();
      result.add(candidates[i]);
      marked.add(result);
      resultMap.get(candidates[i]).add(result);
    }

    for (int move = 1; move <= target; move++) {
      for (int i = 0; i < candidates.length; i++) {
        if (move < candidates[i]) {
          break;
        }
        int otherCandi = move - candidates[i];
        List<List<Integer>> one = resultMap.get(candidates[i]);
        List<List<Integer>> other = resultMap.get(otherCandi);
        for (int oneI = 0; oneI < one.size(); oneI++) {
          for (int otherI = 0; otherI < other.size(); otherI++) {
            List<Integer> result = new ArrayList<>();
            result.addAll(one.get(oneI));
            result.addAll(other.get(otherI));
            Collections.sort(result);
            if (!marked.contains(result)) {
              marked.add(result);
              resultMap.get(move).add(result);
            }
          }
        }
      }
    }
    return resultMap.get(target);
  }

  public static void main(String[] args) {
//    int[] candidates = new int[]{2, 3, 6, 7};
//    int target = 7;
    int[] candidates = new int[]{2, 3, 5};
    int target = 8;
    Leetcode39 leetcode = new Leetcode39();
    ConsoleOutput.printf(leetcode.combinationSum(candidates, target));
  }
}
