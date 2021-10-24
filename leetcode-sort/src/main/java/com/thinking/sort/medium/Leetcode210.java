package com.thinking.sort.medium;

import com.thinking.common.ConsoleOutput;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: Course Schedule II
 * <p>
 * 题目: 给一个数numCourses代表有n门课，课程号是：[0, n-1]。再提供一个数组prerequisites[]，数组prerequisites[]
 * <p>
 * 中每个元素prerequisites[i]=[ai, bi]代表ai课程要修的话，必须先修bi。
 * <p>
 * 求所有修完所有课程的顺序，如果无法修完请返回空数组
 * <p>
 * 思路: 这是一道拓扑排序题，题目的解题入口在于：从入度为0的点出发。
 * <p>
 * 第一步：把所有入度为0的课程添加到队列中
 * <p>
 * 第二步：弹出队列中的某个入度为0的课程，根据课程的依赖关系，将依赖该课程的所有入度-1。-1操作完成后，看下是否入度为0了，
 * <p>
 * 如果入度为0，再将其加到队列中
 * <p>
 * 第三步：如果发现队列空，且所有课程修完了，则返回修课程的顺序
 * <p>
 * 类似题型: Course Schedule
 * <p>
 * Alien Dictionary
 * <p>
 * Minimum height Trees
 * <p>
 * Sequence Reconstruction
 * <p>
 * Course Schedule III
 * <p>
 * Parallel Courses
 *
 * @author thinking_fioa 2021/10/20
 */
public class Leetcode210 {

  /**
   * faster than 32.49%, less than 23.15%
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] inDegree = new int[numCourses];

    Map<Integer, List<Integer>> rect = new HashMap<>();
    for (int[] single : prerequisites) {
      int afterCourse = single[0];
      int beforeCourse = single[1];
      inDegree[afterCourse]++;
      rect.putIfAbsent(beforeCourse, new ArrayList<>());
      rect.computeIfPresent(beforeCourse, (k, v) -> {
        v.add(afterCourse);
        return v;
      });
    }

    int[] result = new int[numCourses];
    int moveIndex = 0;
    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < inDegree.length; i++) {
      if (inDegree[i] == 0) {
        deque.addLast(i);
      }
    }
    while (!deque.isEmpty()) {
      int topCourse = deque.pollFirst();
      result[moveIndex++] = topCourse;
      if (rect.containsKey(topCourse)) {
        List<Integer> afterCourseList = rect.get(topCourse);
        for (Integer single : afterCourseList) {
          inDegree[single]--;
          if (inDegree[single] == 0) {
            deque.addLast(single);
          }
        }
      }
    }
    if (moveIndex != numCourses) {
      return new int[0];
    }
    return result;
  }

  public static void main(String[] args) {
    // Output 0, 2, 1, 3 or 0, 1, 2, 3
    int numCourses = 4;
    int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}};

    // Output [2, 1, 0]
//    int numCourses = 3;
//    int[][] prerequisites = {{0, 1}, {0, 2}, {1, 2}};

    Leetcode210 leetcode210 = new Leetcode210();
    ConsoleOutput.printf(leetcode210.findOrder(numCourses, prerequisites));
  }
}
