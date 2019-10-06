package com.thinking.medium;

/**
 * Title: Unique Paths
 *
 * 题目：给定mxn矩阵，m列和n行，从左上到右下的路径不重复路径条数
 *
 * 超时思路: dfs递归，每次横坐标+1，或竖坐标+1，对于m=51, n=9会超时。具体实现参见Go语言项目
 *
 * dp思路: 定义dp[i][j]为点(1,1)到(i,j)的路径，那么dp[i][j]= dp[i-1][j]+dp[i][j-1]
 *
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 06/10/2019
 */
public class Leetcode62 {

  public int uniquePaths(int m, int n) {
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 1; i <= n; i++) {
      dp[i][1] = 1;
    }
    for (int i = 1; i <= m; i++) {
      dp[1][i] = 1;
    }
    for (int i = 2; i <= n; i++) {
      for (int j = 2; j <= m; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

      }
    }
    return dp[n][m];
  }

  public static void main(String[] args) {
    int m = 7;
    int n = 3;
    Leetcode62 leetcode62 = new Leetcode62();
    System.out.println(leetcode62.uniquePaths(m, n));
  }
}
