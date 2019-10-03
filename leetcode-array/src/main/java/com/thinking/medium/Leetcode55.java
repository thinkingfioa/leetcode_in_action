package com.thinking.medium;

/**
 * Title: Jump Game
 *
 * 给定一个数组nums=[2,3,1,1,4]，每个位置的具体数值代表基于当前位置所能走的最大步数. 问：能否走到数组末尾位置?
 *
 * eg: nums=[2,3,1,1,4], 在nums[0]的位置走一步，然后在nums[1]的位置走三步，到达数组末尾
 *
 * 思路: 能否到数组末尾，走的最远距离maxD能否大于数组长度。他们其实是一一映射的，for循环，条件是i<maxD，maxD在遍历过程中会更新
 *
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 03/10/2019
 */
public class Leetcode55 {

}
