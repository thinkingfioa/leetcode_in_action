package medium;

import com.thinking.ConsoleOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@link Leetcode39}变现题. 区别：候选次数只能使用一次.
 *
 * @author thinking_fioa 14/09/2019
 */
public class Leetcode40 {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> oneResult = new ArrayList<>();

    dfs(candidates, target, 0, result, oneResult);
    return result;
  }

  public void dfs(int[] candidates, int surplus, int beginIndex, List<List<Integer>> result,
      List<Integer> oneResult) {

    if (surplus == 0) {
      result.add(new ArrayList<>(oneResult));
      return;
    }

    if (beginIndex >= candidates.length || candidates[beginIndex] > surplus) {
      return;
    }

    for (int i = beginIndex; i < candidates.length; i++) {
      if (i > beginIndex && candidates[i - 1] == candidates[i]) {
        continue;
      }
      if (candidates[i] > surplus) {
        return;
      }
      oneResult.add(candidates[i]);
      dfs(candidates, surplus - candidates[i], i + 1, result, oneResult);
      oneResult.remove(oneResult.size() - 1);
    }
  }

  public static void main(String[] args) {
    int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    int target = 8;

    Leetcode40 leetcode40 = new Leetcode40();
    List<List<Integer>> result = leetcode40.combinationSum2(candidates, target);

    ConsoleOutput.printf(result);
  }
}
