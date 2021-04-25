package com.thinking.array.medium;

/**
 * Title: Set Matrix Zeroes
 * <p>
 * 题目: 给定二维数组matix[m][n]，找到其中'0'位置，让其所在的行、列所有元素置'0'; 空间复杂度为O(1)
 * <p>
 * 思路: 题目难在空间复杂度为O(1)，求解时需要区别某个'0'位置，是后期置'0'的，还是原先的就是'0'.
 * <p>
 * O(m+n)基本思路：如果使用空间复杂度为O(m+n)，可以定义两个数组rows[m], column[n]，来标记某行、列是否存在元素'0'
 * <p>
 * O(1)思路: 思路来源于O(m+n)，省略rows[m], column[n]，利用row[i](第i行)，column[j](第j列来代替)，用两个
 * <p>
 * 变量先记录下row[i], column[j]，然后将队列中非第i行、第j列部分记录在row[i], column[j]即可。
 * <p>
 * 选择row[i]和column[j]要求是存在'0'元素
 * <p>
 * 参考Go语言项目.
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 13/10/2019
 */
public class Leetcode73 {

}
