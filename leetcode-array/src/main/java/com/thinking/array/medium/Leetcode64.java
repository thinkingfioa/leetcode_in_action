package com.thinking.array.medium;

/**
 * Title: Minimum Path Sum
 * <p>
 * 题目：矩阵最短数字和, 题目思路和Leetcode62, Leetcode63一样.
 * <p>
 * 思路: 仍然使用动态规划思想, 定义dp[i][j]为从点(0,0)到点(i,j)的最短数字和。
 * <p>
 * dp[i][j]=min(dp[i-1][j], dp[i][j-1])+grid[i][j]
 * <p>
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 06/10/2019
 */
public class Leetcode64 {

}
