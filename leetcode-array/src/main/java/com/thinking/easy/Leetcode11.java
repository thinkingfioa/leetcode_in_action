package com.thinking.easy;

/**
 * 利用动归方程，可以内存超出.
 *
 * dp[i][j]=max(dp[i+1][j-1], dp[i+1][j], dp[i][-1], len * min(height[i],[j])
 *
 * AC方法 请参考Go项目. 双指针移动，请思考移动条件：值小的移动指针，能保证结果正确性吗?
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 08/09/2019
 */
public class Leetcode11 {

  public int maxArea(int[] height) {
    int[][] dp = new int[height.length][height.length];
    for (int len = 1; len < height.length; len++) {
      for (int i = 0; i + len < height.length; i++) {
        int j = i + len;
        dp[i][j] = Math
            .max(Math.max(dp[i + 1][j - 1], dp[i + 1][j]), Math.max(dp[i][j - 1],
                len * Math.min(height[i], height[j])));
      }
    }
    return dp[0][height.length - 1];
  }


  public static void main(String[] args) {
    int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
    Leetcode11 leetcode11 = new Leetcode11();
    System.out.println(leetcode11.maxArea(height));
  }
}
