package com.thinking.string.medium;

import com.thinking.ConsoleOutput;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Title: Restore IP Address
 * <p>
 * 题目: 给定一个字符串s，字符串中只包含数字，要求返回所有合法的IP地址。给定的字符串中插入三个点，需要变成合法的IP地址
 * <p>
 * 思路: IP地址的每一位范围是[0, 255]，所以这是一个dfs的算法，每次可以截取1-3个字节，判断是否合法，如果合法，递归进入找下一个合法数字。
 * <p>
 * 类似题型: IP to CIDR
 */
public class Leetcode93 {

  public List<String> restoreIpAddresses(String s) {
    if (s.length() < 4 || s.length() > 12) {
      return new ArrayList<>();
    }
    List<String> result = new ArrayList<>();
    dfsSplit(s, 1, result, new LinkedBlockingDeque<>());
    return result;
  }

  private void dfsSplit(String s, int nodeI, List<String> result, Deque<String> curResult) {
    if (nodeI > 4 || s.isEmpty()) {
      return;
    }
    if (nodeI == 4) {
      if (validIpNode(s)) {
        curResult.add(s);
        result.add(String.join(".", curResult));
        curResult.removeLast();
      }
      return;
    }
    for (int i = 1; i <= 3 && i <= s.length(); i++) {
      String subStr = s.substring(0, i);
      String otherStr = s.substring(i);
      if (validIpNode(subStr)) {
        curResult.add(subStr);
        dfsSplit(otherStr, nodeI + 1, result, curResult);
        curResult.removeLast();
      }
    }
  }

  private boolean validIpNode(String ipNode) {
    if (ipNode.isEmpty() || ipNode.length() > 3) {
      return false;
    }
    if (ipNode.length() != 1 && ipNode.charAt(0) == '0') {
      return false;
    }
    int ipNodeI = Integer.parseInt(ipNode);
    return ipNodeI >= 0 && ipNodeI <= 255;
  }

  public static void main(String[] args) {
    // Output ["255.255.11.135","255.255.111.35"]
//    String s = "25525511135";
    // Output ["0.0.0.0"]
//    String s = "0000";
    // Output ["1.1.1.1"]
//    String s = "1111";
    // Output ["0.10.0.10","0.100.1.0"]
//    String s = "010010";
    // Output ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
    String s = "101023";
    Leetcode93 leetcode93 = new Leetcode93();
    ConsoleOutput.printf(leetcode93.restoreIpAddresses(s));
  }
}
