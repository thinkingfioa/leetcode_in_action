package com.thinking.string.medium;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Compare Version Numbers
 * <p>
 * 题目: 给两个字符串：version1和version2。格式是A.B.C.D。其中A、B、C和D由阿拉伯数字组成，但也可能是空串
 * <p>
 * 或者具有前导'0'的数字（如: "000987"）。比较version1和version2:
 * <p>
 * 如果 version1 > version2，输出：1
 * <p>
 * 如果 version1 < version2，输出：-1
 * <p>
 * 如果 version1 = version2，输出：0
 * <p>
 * 思路: 字符串version1和字符串version2先通过split(\\.)方法分成数组array1[]和array2[]，
 * <p>
 * 然后从下标0开始比较两个数组的每个元素: array1[i] > array2[i]
 * <p>
 * 类似题型: One Edit Distance
 * <p>
 * Bold Words in String
 * <p>
 * Check If a String Contains All Binary Codes of Size K
 *
 * @author vlin 2021/11/22
 */
public class Leetcode165 {

  /**
   * faster than 15.26%，less than 25.03%
   */
  public int compareVersion(String version1, String version2) {
    String[] ver1Array = version1.split("\\.");
    String[] ver2Array = version2.split("\\.");

    int maxNum = Math.max(ver1Array.length, ver2Array.length);
    for (int index = 0; index < maxNum; index++) {
      String splitV1 = index < ver1Array.length ? ver1Array[index] : "0";
      String splitV2 = index < ver2Array.length ? ver2Array[index] : "0";
      int cmpResult = cmp(splitV1, splitV2);
      if (cmpResult != 0) {
        return cmpResult;
      }
    }

    return 0;
  }

  private int cmp(String v1, String v2) {
    if (v1.trim().equals("")) {
      v1 = "0";
    }
    if (v2.trim().equals("")) {
      v2 = "0";
    }
    if (v1.trim().equals(v2.trim())) {
      return 0;
    }
    int v1Int = Integer.parseInt(v1);
    int v2Int = Integer.parseInt(v2);
    if (v1Int == v2Int) {
      return 0;
    }
    return v1Int > v2Int ? 1 : -1;
  }

  public static void main(String[] args) {
    // Output -1
    String version1 = "7.5.2.4";
    String version2 = "7.5.3";

    Leetcode165 leetcode165 = new Leetcode165();
    ConsoleOutput.printf(leetcode165.compareVersion(version1, version2));
  }
}
