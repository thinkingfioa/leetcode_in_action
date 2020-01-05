package com.thinking.medium;

/**
 * Title: Find Minimum in Rotated Sorted Array
 *
 * 题目: 给一个循环数组nums[4,5,6,7,0,1,2]。找到最小数的元素。假定数字不会重复
 *
 * 思路: 类似题型，基本都是二分法，如果 nums[mid] < nums[right]， 则最小值在[left, mid]之间， 否则[mid+1, right]
 *
 * 类似题型: Leetcode33
 *
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 2020/1/3
 */
public class Leetcode153 {

}
