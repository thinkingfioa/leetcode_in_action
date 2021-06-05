package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Reverse Words in a String
 * <p>
 * 题目:
 * <p>
 * 思路
 * <p>
 * 类似题型:
 *
 * @author thinking_fioa 2021/6/5
 */
public class Leetcode151 {

  /**
   * faster than 51.01%，less than 74.00%
   */
  public String reverseWords(String s) {
    String str = s.replaceAll("[ ]+", " ").trim();
    String[] strList = str.split(" ");
    StringBuilder sb = new StringBuilder();
    sb.append(strList[strList.length - 1]);
    for (int i = strList.length - 2; i >= 0; i--) {
      sb.append(" ").append(strList[i]);
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    // "blue is sky the"
//    String s = "the sky is blue";
//    // "world hello"
    String s = "  hello world  ";
//    // "example good a"
//    String s = "a good   example";
//    // "example good a"
//    String s = "a good   example";
    Leetcode151 leetcode151 = new Leetcode151();
    ConsoleOutput.printf(leetcode151.reverseWords(s));
  }
}
