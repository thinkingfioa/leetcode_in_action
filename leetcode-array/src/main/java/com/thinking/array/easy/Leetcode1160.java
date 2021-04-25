package com.thinking.array.easy;

import com.thinking.common.ConsoleOutput;

/**
 * @author thinking_fioa 2020/7/27
 */
public class Leetcode1160 {

  public int countCharacters(String[] words, String chars) {
    int count = 0;

    for (int i = 0; i < words.length; i++) {
      String str = words[i];
      int j = 0;
      String tempChars = chars;
      for (; j < str.length(); j++) {
        if (tempChars.contains(str.substring(j, j + 1))) {
          tempChars = tempChars.replace(str.substring(j, j + 1), "");
        } else {
          break;
        }
      }
      if (j == str.length()) {
        System.out.println(str);
        count += str.length();
      }


    }

    return count;

  }

  public static void main(String[] args) {
    String[] words = {"hello", "world", "leetcode"};
    String chars = "welldonehoneyr";

    Leetcode1160 l = new Leetcode1160();
    ConsoleOutput.printf(l.countCharacters(words, chars));
  }
}
