package com.thinking.array.medium;

import com.thinking.common.GolbalInstance;

/**
 * Title: Find First and Last Position of Elements in SortedArray
 * <p>
 * 给定有序数组， nums ={5,7,7,8,8,10} and target = 8，输出第一个和最后一次出现的下标.
 * <p>
 * 思路: 二分查找，第一个找左边第一个匹配，第二次找右边第一个匹配.
 * <p>
 * Java实现用非递归方式实现二分查找
 * <p>
 * Go语言项目是用递归实现二分查找， 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 28/09/2019
 */
public class Leetcode34 {

  public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    int leftIndex = leftBinarySearch(nums, 0, nums.length - 1, target);
    if (leftIndex == -1) {
      result[0] = -1;
      result[1] = -1;
      return result;
    }
    int rightIndex = rightBinarySearch(nums, leftIndex, nums.length - 1, target);
    result[0] = leftIndex;
    result[1] = rightIndex;
    return result;
  }

  public int leftBinarySearch(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if ((mid == left || nums[mid - 1] != target) && nums[mid] == target) {
        return mid;
      }
      if (nums[mid] >= target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public int rightBinarySearch(int[] nums, int left, int right, int target) {
    while (left <= right) {
      int mid = (left + right) / 2;
      if ((mid == right || nums[mid + 1] != target) && nums[mid] == target) {
        return mid;
      }
      if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
//    int[] nums = {5, 7, 7, 8, 8, 10};
//    int target = 6;

    int[] nums = {1};
    int target = 0;

    Leetcode34 leetcode34 = new Leetcode34();
    int[] result = leetcode34.searchRange(nums, target);
    System.out.println(GolbalInstance.GSON_PRETTY.toJson(result));
  }
}
