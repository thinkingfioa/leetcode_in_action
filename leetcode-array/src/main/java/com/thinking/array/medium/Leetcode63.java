package com.thinking.array.medium;

/**
 * Title: Unique Paths II，类似于Leetcode62题目变形题
 * <p>
 * 题目：给定mxn矩阵，m列和n行，其中有(i,j)是阻碍物，从左上到右下的路径不重复路径条数.
 * <p>
 * 提醒：当某一行出现为阻碍物后，后序所有的都是不可达
 * <p>
 * 思路：动归思路, 定义dp[i][j]为点(1,1)到(i,j)的路径，dp[i][j]= dp[i-1][j]+dp[i][j-1]
 * <p>
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 06/10/2019
 */
public class Leetcode63 {

}
