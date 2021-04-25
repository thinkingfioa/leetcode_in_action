package com.thinking.array.medium;

/**
 * Title: Search a 2D Matrix
 * <p>
 * 题目: 给定一个二维数组mxn. row[i]中数字递增，row[i-1]中最后一个数字 < row[i]第一个数字。设计查找算法
 * <p>
 * 思路: 典型二分查找变形题. 先对column[0]的进行二分查找，定位具体的行row[i]，然后在对row[i]进行二分查找
 * <p>
 * * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 27/10/2019
 */
public class Leetcode74 {

}
