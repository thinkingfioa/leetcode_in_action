package com.thinking.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author thinking_fioa 04/09/2019
 */
public class CommonUtil {

  /**
   * {@link List <Integer>}递增排序.
   */
  public static void sortListAsc(List<Integer> numList) {
    Collections.sort(numList);
  }

  /**
   * 对int[]数组排序
   */
  public static void sortArrayAsc(int[] nums) {
    Arrays.sort(nums);
  }
}
