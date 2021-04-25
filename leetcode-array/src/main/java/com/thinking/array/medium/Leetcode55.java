package com.thinking.array.medium;

/**
 * Title: Jump Game
 * <p>
 * 给定一个数组nums=[2,3,1,1,4]，每个位置的具体数值代表基于当前位置所能走的最大步数. 问：能否走到数组末尾位置?
 * <p>
 * eg: nums=[2,3,1,1,4], 在nums[0]的位置走一步，然后在nums[1]的位置走三步，到达数组末尾
 * <p>
 * 思路: 每个点的位置i，都有一个能走的最远距离，我们从i开始，一直尝试往前走，如果发现有更远的距离就更新maxD，走的过程中发现maxD可以到数组尾部，说明能到
 * <p>
 * 如果把[i, maxD]所有下标都走完，发现还没到尾部，那么就是到不了了
 * <p>
 * 参考Go语言项目.
 * <p>
 * 类似题型: Jump Game II
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 03/10/2019
 */
public class Leetcode55 {

}
