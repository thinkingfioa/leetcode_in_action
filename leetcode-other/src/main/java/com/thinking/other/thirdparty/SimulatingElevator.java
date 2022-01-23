package com.thinking.other.thirdparty;

import com.thinking.common.ConsoleOutput;

/**
 * Title: Simulator Elevator 电梯模拟
 * <p>
 * 题目: 第一个数字num表示有多少个乘客，第二个数字表示目前电梯所在的楼层，
 * <p>
 * 第三个是一个二维数组target[][]，行数是num，二维数组中target[index][0], target[index][1]表示
 * <p>
 * 第index+1个乘客所在的楼层和目的楼层。
 * <p>
 * 约束条件:
 * <p>
 * 1. 电梯中没有超载人数概念，能容纳很多人
 * <p>
 * 2. 电梯空的时候，立马去接人
 * <p>
 * 3. 如果已经有乘客在电梯上，其他乘客上电梯，必须与电梯目前运行方向一致
 * <p>
 * 4. 乘客是一个一个出现，只有第i个乘客上电梯了，第i+1个乘客才会出现。
 * <pre>
 *   input : num = 4, storey = 50, target= {{50, 10}, {40, 20}, {30,100}, 30, 100}
 *
 *   output: 40 + 90 + 70 + 70 = 270
 * </pre>
 * <p>
 * 思路: 按照题目的思路，定义direction来标记当前电梯的方向。只有乘客与电梯运行方向相同，且乘客目前在的楼层处于
 * <p>
 * 电梯会运行过的路径，才可以上车。
 * <p>
 * 定义第一个for循环来遍历整个target，在第一个for循环里面，判断第i+1个人与第i个人的关系
 * <p>
 * 来源: HW专业级
 *
 * @author vlin 2022/1/23
 */
public class SimulatingElevator {

  /**
   * @param num         乘坐电梯人数
   * @param beginStorey 电梯开始楼层
   * @param target      所在的楼层，要去的楼层
   */
  private int simulatingElevator(int num, int beginStorey, int[][] target) {
    // 0 -> 向下； 1 -> 向上
    int direction = 0;
    int result = 0;

    int curStorey = beginStorey;
    int toStorey = target[0][0];
    result = Math.abs(curStorey - toStorey);
    curStorey = toStorey;
    for (int i = 0; i < target.length; i++) {
//      System.out.printf("i=%d\n", i);
      if (curStorey != target[i][0]) {
        result += Math.abs(curStorey - target[i][0]);
        curStorey = target[i][0];
      }

      toStorey = target[i][1];
      if (curStorey == toStorey) {
        continue;
      }
      if (curStorey < toStorey) {
        direction = 1;
      } else {
        direction = 0;
      }
      while (i + 1 < target.length) {
        if (direction == 1 && target[i + 1][0] > target[i][0]
            && target[i + 1][0] <= target[i + 1][1]) {
          toStorey = Math.max(toStorey, target[i + 1][1]);
          i++;
        } else if (direction == 0 && target[i + 1][0] < target[i][0]
            && target[i + 1][0] >= target[i + 1][1]) {
          toStorey = Math.min(toStorey, target[i + 1][1]);
          i++;
        } else {
          break;
        }
      }
//
//      System.out.printf("cur = %d, to = %d, diff = %d\n", curStorey, toStorey,
//          Math.abs(curStorey - toStorey));
      result += Math.abs(curStorey - toStorey);
      curStorey = toStorey;
    }

    return result;
  }

  public static void main(String[] args) {
    // Output 270
//    int num = 4;
//    int storey = 50;
//    int[][] target = {{50, 10}, {40, 20}, {30, 100}, {30, 100}};

    // Output 109
    int num = 3;
    int storey = 50;
    int[][] target = {{12, 66}, {25, 27}, {26, 83}};

    SimulatingElevator simulatingElevator = new SimulatingElevator();
    ConsoleOutput.printf(simulatingElevator.simulatingElevator(num, storey, target));
  }
}
