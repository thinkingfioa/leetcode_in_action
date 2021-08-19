package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: Letter Combinations of a Phone Number
 * <p>
 * 题目：给定一个数字数组digits[]，digits[]数组中的每个元素都是2-9数字组成，根据9宫格的标准，输出组合出来的所有字母的情况
 * <p>
 * 思路：典型的DFS思路，每一层都遍历一遍，参与结果的组合。当递归的层级大于digits.size()时，则找到一种结果
 * <p>
 * 类似题型: Generate Parentheses
 * <p>
 * Binary Watch
 *
 * @author thinking_fioa 2021/8/8
 */
public class Leetcode17 {

  /**
   * faster than 44.14%, less than 22.12%
   */
  public List<String> letterCombinations(String digits) {
    String[] mapping = {
        "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    List<String> charList = new ArrayList<>();
    if ("".equals(digits)) {
      return charList;
    }
    for (int i = 0; i < digits.length(); i++) {
      int digit = Integer.parseInt(String.valueOf(digits.charAt(i)));
      charList.add(mapping[digit - 1]);
    }

    List<String> resultList = new ArrayList<>();
    dfs(resultList, "", 0, charList);
    return resultList;
  }

  private void dfs(List<String> resultList, String result, int layer, List<String> charList) {
    if (layer >= charList.size()) {
      resultList.add(result);
      return;
    }
    String curStr = charList.get(layer);
    for (int i = 0; i < curStr.length(); i++) {
      dfs(resultList, result + curStr.charAt(i), layer + 1, charList);
    }
  }

  public static void main(String[] args) {
    // "ad","ae","af","bd","be","bf","cd","ce","cf"
    String digits = "23";
    Leetcode17 leetcode17 = new Leetcode17();
    ConsoleOutput.printf(leetcode17.letterCombinations(digits));
  }
}
