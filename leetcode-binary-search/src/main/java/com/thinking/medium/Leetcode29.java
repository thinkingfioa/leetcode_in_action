package com.thinking.medium;

/**
 * Title: Divide two Integers
 *
 * 题目：给两个整数。 dividend / divisor ，求商。 不允许使用乘法，除法和取余运算符.
 *
 * 思路：两个数相除m/n，通俗的说，就是不断的m=m-n，直到m<n。所以可以通过位操作
 *
 * <pre>
 * <br>eg:
 * <li>
 *   a=10/b=3 = 10 - b*2^0 - b*2^1 =1 <b，则商就是2^0+2^1
 * </li>
 * <li>
 *   a=15/b=2 = 15 - b*2^0 - b*2^1 - b*2^2 =1 < b，则商就是2^0+2^1+2^2
 * </li>
 * </pre>
 *
 * 提醒：需要考虑数值越界
 *
 * @author thinking_fioa 13/12/2019
 */
public class Leetcode29 {

  public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    // false 代表正数， true- 负数
    boolean signFlag = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
    long dividendL = Math.abs((long) dividend);
    long divisorL = Math.abs((long) divisor);
    long result = 0;
    while (dividendL >= divisorL) {
      long moreDivisor = divisorL;
      long n = 1;
      while (dividendL >= moreDivisor << 1) {
        moreDivisor = moreDivisor << 1;
        n = n << 1;
      }
      dividendL -= moreDivisor;
      result += n;
    }
    return signFlag ? -(int) result : (int) result;
  }

  public static void main(String[] args) {
    int dividend = -2147483648;
    int divisor = 1;
    Leetcode29 leetcode29 = new Leetcode29();
    System.out.println(leetcode29.divide(dividend, divisor));
  }
}
