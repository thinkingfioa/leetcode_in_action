package com.thinking.array.medium;

/**
 * Title: Sort Colors
 * <p>
 * 题目: 给定一个数组nums，'0', '1', '2'分别代表颜色red, white, blue。要求将相同的颜色摆放在一起，常量空间.
 * <p>
 * 思路1: 2次遍历，第一次遍历分别记录'0', '1', '2'各出现的次数为a,b,c，第二遍遍历重写a,b,c个'0', '1', '2'
 * <p>
 * 思路2: 一次遍历，三个指针，left左指针指向'0'，right右指针指针'2'，一个move指针指向'1'。left指向非'0'的值，right窒息那个非'2'值。 move
 * 从左往右一次遍历
 *
 * <pre>
 *  https://github.com/thinkingfioa/go-learning/tree/master/leetcode-in-action/src/leetcode-array
 * </pre>
 *
 * @author thinking_fioa 28/10/2019
 */
public class Leetcode75 {

}
