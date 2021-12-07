package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;
import java.util.regex.Pattern;

/**
 * Title: Validate IP Address
 * <p>
 * 题目: 给定一个字符串，判断字符串是否是IPv4或这IPv6，如果两个都不是，输出"Neither"
 * <p>
 * IPv4需要符合"x1.x2.x3.x4"格式，0<=xi<=255 && 能有前导0
 * <p>
 * IPv6需要符合"x1:x2:x3:x4:x5:x6:x7:x8"格式，1<=xi.length<=4 && xi中每个是十六进值的数
 * <p>
 * 思路1: 使用代码split(\\.)来将IPv4和IPv6各个域拆拆开，每个域来判断合法性
 * <p>
 * 思路2: 使用Java的正则表达方式。对于IPv4要注意，单个xi为三位数字时候1开头和24或25开头需要单独判断
 * <p>
 * 类似题型:
 *
 * @author vlin 2021/11/22
 */
public class Leetcode468 {

  /**
   * faster than 98.37%，less than 35.58%
   */
  public String validIPAddress(String queryIP) {
    if (null == queryIP || queryIP.trim().isEmpty()) {
      return "Neither";
    }

    if (isIpv4(queryIP)) {
      return "IPv4";
    }
    if (isIpv6(queryIP)) {
      return "IPv6";
    }
    return "Neither";
  }

  private boolean isIpv4(String queryIP) {
    if (queryIP.endsWith(".")) {
      return false;
    }
    String[] subIpArray = queryIP.split("\\.");
    if (subIpArray.length != 4) {
      return false;
    }

    return isSubIpv4(subIpArray[0]) && isSubIpv4(subIpArray[1]) && isSubIpv4(subIpArray[2])
        && isSubIpv4(subIpArray[3]);
  }

  private boolean isSubIpv4(String subIp) {
    if (subIp.equals("0")) {
      return true;
    }
    if (subIp.isEmpty() || subIp.length() > 3 || subIp.charAt(0) == '0') {
      return false;
    }
    if (!isSubIpv4Icon(subIp.charAt(0))
        || !(subIp.length() >= 2 ? isSubIpv4Icon(subIp.charAt(1)) : true)
        || !(subIp.length() >= 3 ? isSubIpv4Icon(subIp.charAt(2)) : true)) {
      return false;
    }

    return Integer.parseInt(subIp) <= 255;
  }

  private boolean isSubIpv4Icon(char c) {
    return '0' <= c && c <= '9';
  }

  private boolean isIpv6(String queryIP) {
    if (queryIP.endsWith(":")) {
      return false;
    }
    String[] subIpArray = queryIP.split(":");
    if (subIpArray.length != 8) {
      return false;
    }

    return isSubIpv6(subIpArray[0]) && isSubIpv6(subIpArray[1]) && isSubIpv6(subIpArray[2])
        && isSubIpv6(subIpArray[3]) && isSubIpv6(subIpArray[4]) && isSubIpv6(subIpArray[5])
        && isSubIpv6(subIpArray[6]) && isSubIpv6(subIpArray[7]);
  }

  private boolean isSubIpv6(String subIp) {
    if (subIp.isEmpty() || subIp.length() > 4) {
      return false;
    }

    return isSubIpv6Icon(subIp.charAt(0))
        && (subIp.length() >= 2 ? isSubIpv6Icon(subIp.charAt(1)) : true)
        && (subIp.length() >= 3 ? isSubIpv6Icon(subIp.charAt(2)) : true)
        && (subIp.length() >= 4 ? isSubIpv6Icon(subIp.charAt(3)) : true);
  }

  private boolean isSubIpv6Icon(char c) {
    return '0' <= c && c <= '9' || 'a' <= c && c <= 'f' || 'A' <= c && c <= 'F';
  }


  /**
   * faster than 26.71%，less than 47.36%
   */
  private static final String IPV4
      = "^([0-9]{1}|[1-9]{1}[0-9]{1}|1[0-9]{2}|2[0-4]{1}[0-9]{1}|25[0-5]{1})"
      + "\\.([0-9]{1}|[1-9]{1}[0-9]{1}|1[0-9]{2}|2[0-4]{1}[0-9]{1}|25[0-5]{1})"
      + "\\.([0-9]{1}|[1-9]{1}[0-9]{1}|1[0-9]{2}|2[0-4]{1}[0-9]{1}|25[0-5]{1})"
      + "\\.([0-9]{1}|[1-9]{1}[0-9]{1}|1[0-9]{2}|2[0-4]{1}[0-9]{1}|25[0-5]{1})$";
  private static final Pattern IPV4_PATTERN = Pattern.compile(IPV4);

  private static final String IPV6
      = "^[0-9a-fA-F]{1,4}:[0-9a-fA-F]{1,4}:[0-9a-fA-F]{1,4}:[0-9a-fA-F]{1,4}"
      + ":[0-9a-fA-F]{1,4}:[0-9a-fA-F]{1,4}:[0-9a-fA-F]{1,4}:[0-9a-fA-F]{1,4}$";
  private static final Pattern IPV6_PATTERN = Pattern.compile(IPV6);

  public String validIPAddress2(String queryIP) {
    if (IPV4_PATTERN.matcher(queryIP).find()) {
      return "IPv4";
    }

    if (IPV6_PATTERN.matcher(queryIP).find()) {
      return "IPv6";
    }

    return "Neither";
  }

  public static void main(String[] args) {
    // Output IPv4
//    String queryIP = "172.16.256.1";

    // Output IPv6
    String queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334:";

    Leetcode468 leetcode468 = new Leetcode468();
    ConsoleOutput.printf(leetcode468.validIPAddress(queryIP));
  }

}
