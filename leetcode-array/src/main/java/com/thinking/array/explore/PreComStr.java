package com.thinking.array.explore;

import com.thinking.common.ConsoleOutput;

/**
 * @author thinking_fioa 2020/7/19
 */
public class PreComStr {

  public String longestCommonPrefix(String[] strs) {
    StringBuilder sb = new StringBuilder();

    int minPos = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; i++) {
      minPos = Math.min(minPos, strs[i].length());
    }
    if (minPos == 0 || minPos == Integer.MAX_VALUE) {
      return "";
    }

    for (int i = 0; i < minPos; i++) {
      char c = strs[0].charAt(i);
      int j = 1;
      for (; j < strs.length; j++) {
        if (c != strs[j].charAt(i)) {
          break;
        }
      }
      if (j != strs.length) {
        break;
      }
      sb.append(String.valueOf(c));
    }
    return sb.toString();
  }

  public static void main(String[] args) {

    String[] strs = {"flower", "flow", "flight"};

    PreComStr preComStr = new PreComStr();
    ConsoleOutput.printf(preComStr.longestCommonPrefix(strs));
  }

}
