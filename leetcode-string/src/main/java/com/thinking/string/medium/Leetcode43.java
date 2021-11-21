package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: Multiply Strings
 * <p>
 * 题目：给两个非负数的num1和num2，两个数都用字符串表示。求两个大数相乘的结果，以字符串的方式输出.
 * <pre>
 *   输出：num1 = "123", num2 = "456"
 *   输出："56088"
 * </pre>
 * 思路：
 * <p>
 * 类似题型: Add Binary
 * <p>
 * Add Strings
 *
 * @author vlin 2021/11/21
 */
public class Leetcode43 {

  /**
   * faster than 14.00%，less than 31.61%
   */
  public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
      return "0";
    }

    if (num1.length() < num2.length()) {
      String tmp = num1;
      num1 = num2;
      num2 = tmp;
    }
    List<String> resultList = new ArrayList<>();

    int loop = 0;
    for (int beginNum2 = num2.length() - 1; beginNum2 >= 0; beginNum2--) {
      StringBuilder multiply = new StringBuilder();
      int suply = 0;
      for (int beginNum1 = num1.length() - 1; beginNum1 >= 0; beginNum1--) {
        int number1 = Integer.parseInt(String.valueOf(num1.charAt(beginNum1)));
        int number2 = Integer.parseInt(String.valueOf(num2.charAt(beginNum2)));
        int n = suply + number1 * number2;
        multiply.append(n % 10);
        suply = n / 10;
      }
      while (suply != 0) {
        int n = suply;
        multiply.append(n % 10);
        suply = n / 10;
      }
      // add '0'
      for (int i = 0; i < loop; i++) {
        multiply.insert(0, '0');
      }
      loop++;
      resultList.add(multiply.toString());
    }

    StringBuilder result = new StringBuilder();
    int size = resultList.size();
    int max = resultList.get(size - 1).length();
    int suply = 0;
    for (int i = 0; i < max; i++) {
      for (String str : resultList) {
        if (i < str.length()) {
          suply += Integer.parseInt(String.valueOf(str.charAt(i)));
        }
      }
      result.insert(0, suply % 10);
      suply = suply / 10;
    }
    while (suply != 0) {
      result.insert(0, suply % 10);
      suply = suply / 10;
    }
    return result.toString();
  }

  public static void main(String[] args) {
    // Output "56088"
    String num1 = "123";
    String num2 = "456";

    Leetcode43 leetcode43 = new Leetcode43();
    ConsoleOutput.printf(leetcode43.multiply(num1, num2));
  }
}
