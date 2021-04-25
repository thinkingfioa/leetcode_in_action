package com.thinking.array.medium;

/**
 * Title Search in Rotated Sorted Array
 * <p>
 * 一个数组nums={4,5,6,7,0,1,2}, target=0。其中数组nums 是一个有序数组，且被循转过。查找target下标
 * <p>
 * 思路: 二分查找, [left, mid, right]必有一个是顺序的，来判断下次二分位置。nums[left] < nums[mid]则左边是有序的
 * <p>
 * 类似题型: Leetcode153
 * <p>
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 28/09/2019
 */
public class Leetcode33 {

}
