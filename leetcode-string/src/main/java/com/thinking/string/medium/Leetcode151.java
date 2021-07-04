package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Reverse Words in a String
 * <p>
 * 题目：给定一个字符串，要求将字符串中的所有单词逆转。比如给定一个s="blue is sky the"，输出结果为output="the sky is blue"
 * <p>
 * 单词之间可能有一个或多个空格.
 * <p>
 * <p>
 * 思路：题目要求不开辟空间，但是java语言中String是常量，意味着不可能。
 * <p>
 * 通过Java语言实现，题目比较简单，分为两个步骤：
 * <p>
 * 步骤1：将字符串中多个空格替换成单个空格
 * <p>
 * 步骤2：字符串按照空格切分，逆序遍历切分后的数组。
 * <p>
 * 类似题型: Reverse Words in a String II
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
