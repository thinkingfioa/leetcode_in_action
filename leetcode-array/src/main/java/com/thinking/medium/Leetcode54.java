package com.thinking.medium;

/**
 * Title: Spiral Matrix
 *
 * 给定一个二维数组matrix{{1,2,3}, {4,5,6}, {7,8,9}}，按照顺时针循环输出. eg: 1，2，3，6，9，8，7，4，5
 *
 * 思路: 共循环次数=(min(row, column)+1)/2，每次起点是(0,0)、(1,1)...。
 *
 * 四个方向，分为4个函数，分别是: 从左到右， 从上到下， 从右到左，从下到上
 *
 * 速度和效率都非常高
 *
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 02/10/2019
 */
public class Leetcode54 {

}
