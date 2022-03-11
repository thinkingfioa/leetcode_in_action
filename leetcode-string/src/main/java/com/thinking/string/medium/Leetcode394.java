package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Title: Decode String
 * <p>
 * 题目: 给定一个字符串，字符串中存在"k[encode_str]"类型的字串，其中k是一个数字型，encode_str是字串，
 * <p>
 * "k[encode_str]"代表有k个字串encode_str组成，即：$encode_str$encode_str$encode_str...
 * <p>
 * 提醒：encode_str中也可以有"k[encode_str]"类型的字串。请还原出原串。
 *
 * <pre>
 *   input :  3[a2[c]]
 *   output： accaccacc
 * </pre>
 * <p>
 * 思路: 使用队列，特殊处理字符串中几个关键的字符类型
 * <p>
 * 第一个：数字。对于数字，当发现某个char在['0','9']之间时，利用while循环，将整个数字截取下来，存放到队列中
 * <p>
 * 第二个：对于']'时，需要从队列中弹出字符，拼成子字符串subStr，直到遇到'['时，意味着下个时一个数字num。
 * <p>
 * 利用弹出的数字num和字符串subStr，拼成完成的字符串，入队列
 * <p>
 * 第三个：其他字符类型一律入队列
 * <p>
 * 类似题型: Encode String with Shortest Length
 * <p>
 * Number of Atoms
 * <p>
 * Brace Expansion
 *
 * @author vlin 2021/12/22
 */
public class Leetcode394 {

  private static final Character LEFT_SQUARE = '[';
  private static final Character RIGHT_SQUARE = ']';

  /**
   * faster than 60.88%，less than 71.57%
   */
  public String decodeString(String s) {
    if (s == null || s.length() <= 1) {
      return s;
    }
    Deque<String> deque = new ArrayDeque<>();

    for (int i = 0; i < s.length(); i++) {
      char single = s.charAt(i);
      if (single == RIGHT_SQUARE) {
        StringBuilder subSb = new StringBuilder();
        while (!deque.isEmpty()) {
          String top = deque.pollLast();
          if ("[".equals(top)) {
            String numTop = deque.pollLast();
            String subStr = append(Integer.parseInt(numTop), subSb.toString());
            deque.add(subStr);
            break;
          } else {
            subSb.insert(0, top);
          }
        }

      } else if (single >= '0' && single <= '9') {
        int begin = i;
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
          i++;
        }
        String subStr = s.substring(begin, i);
        deque.add(subStr);
        i = i - 1;
      } else {
        deque.add(String.valueOf(single));
      }
    }

    StringBuilder result = new StringBuilder();
    while (!deque.isEmpty()) {
      result.append(deque.pollFirst());
    }

    return result.toString();
  }

  private String append(int count, String str) {
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < count; i++) {
      result.append(str);
    }
    return result.toString();
  }

  public static void main(String[] args) {
//    // Output accaccacc
//    String s = "3[a2[c]]";

    // Output abcabccdcdcdef
    String s = "2[abc]3[cd]ef";

    Leetcode394 leetcode394 = new Leetcode394();
    ConsoleOutput.printf(leetcode394.decodeString(s));
  }
}
