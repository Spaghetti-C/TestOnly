//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1368 👎 0

//frontendQuestionId:39

package com.yy.algorithm.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        int[] candidates = {2, 3, 5};
        System.out.println(solution.combinationSum(candidates, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> lists = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            backtrack(candidates, target, 0, 0, list, lists);
            return lists;
        }

        private void backtrack(int[] candidates, int target, int start, int sum, List<Integer> list, List<List<Integer>> lists) {
            if (sum > target) {
                return;
            }
            if (sum == target) {
                lists.add(new LinkedList(list));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                list.add(candidates[i]);
                backtrack(candidates, target, i, sum + candidates[i], list, lists);
                list.remove(new Integer(candidates[i]));
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}