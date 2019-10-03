package com.thinking.medium;

/**
 * Title ： Rotate Image
 *
 * 给定一个二维数组 matrix[N][N]代表一个Image，顺时针循转90度。空间复杂度为O(1)
 *
 * 思路: 顺时针旋转 == 先行翻转，再斜对角线翻转。先行翻转，行的逆序。斜对角线翻转公式(i, j) <-> (n-1-j, n-1-i)
 *
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 29/09/2019
 */
public class Leetcode48 {

}
