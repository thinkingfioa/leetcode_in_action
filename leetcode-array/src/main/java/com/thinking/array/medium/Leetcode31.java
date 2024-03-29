package com.thinking.array.medium;

/**
 * 排列问题. 给定数组{1,1,5}，输入下一个排列.
 * <p>
 * 思路: 从右往左找num1, num2(num1 < num2)递减点，则是排列分割点. 从后面点中找到替代的位置，也就是第一个大于的num1的位置，交换。再排序即可
 * <p>
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 25/09/2019
 */
public class Leetcode31 {

}
