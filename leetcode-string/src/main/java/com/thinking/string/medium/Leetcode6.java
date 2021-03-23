package com.thinking.string.medium;

import com.thinking.ConsoleOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * Title: ZigZag Conversion
 * <p>
 * 题目: 给定一个字符串s和一个数字n，将字符串按ZigZag顺序排列后，按照行输出。ZigZag格式如下:
 * <pre>
 *  1:    s[0]                                 s[2n-2]
 *  2:    s[1]                      s[2n-2-1]  s[2n-1]
 *  3:    s[2]             s[2n-2-2]           s[2n]
 *  4:    s[3]    s[2n-2-3]                    s[2n+1]
 *  ...   ....                                 ...
 *  n:    s[n-1]                               s[3n-3]
 * </pre>
 * <p>
 * 思路: 先定义n维的列表，每行存放转换后字符串。按照ZigZag的规则，先将字符串s分为多个子串，每段的长度为2n-2。
 * <p>
 * 对于每个子串subStr，当字串下标i<n时，应该直接能映射到n维的列表中；i>=n时，应该映射到2n-2 - i的下标中
 * <p>
 * 类似题型: Simplify Path
 * <p>
 * Find the Longest Substring Containing Vowels in Even Counts
 * <p>
 * ReplaceAll?'s to Avoid Consecutive Repeating Characters
 *
 * @author thinking_fioa 2021/3/22
 */
public class Leetcode6 {

  public String convert(String s, int numRows) {
    List<StringBuilder> sbList = new ArrayList<>();
    for (int i = 0; i < numRows; i++) {
      sbList.add(new StringBuilder());
    }
    if (numRows < 2) {
      return s;
    }
    int singleLen = 2 * numRows - 2;
    int count = s.length() / singleLen + (s.length() % singleLen == 0 ? 0 : 1);

    for (int i = 0; i < count; i++) {
      int beginIndex = i * singleLen;
      int endIndex = Math.min(beginIndex + singleLen, s.length());
      String subStr = s.substring(beginIndex, endIndex);
      for (int j = 0; j < subStr.length(); j++) {
        char c = subStr.charAt(j);
        if (j < numRows) {
          sbList.get(j).append(c);
        } else {
          sbList.get(singleLen - j).append(c);
        }
      }
    }
    // 整理结果
    StringBuilder result = new StringBuilder();
    for (StringBuilder sb : sbList) {
      result.append(sb);
    }
    return result.toString();
  }

  public static void main(String[] args) {
//    // Output: PAHNAPLSIIGYIR
//    String s = "PAYPALISHIRING";
//    int numRows = 3;
//    // Output: PINALSIGYAHRPI
//    String s = "PAYPALISHIRING";
//    int numRows = 4;
    // Outout: A
    String s = "A";
    int numRows = 1;
    Leetcode6 leetcode6 = new Leetcode6();
    ConsoleOutput.printf(leetcode6.convert(s, numRows));
  }
}
