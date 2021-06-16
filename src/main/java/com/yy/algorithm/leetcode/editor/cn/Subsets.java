//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1212 👎 0

//frontendQuestionId:78

package com.yy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        Solution solution = new Subsets().new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(solution.subsets(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            backtrack(nums, 0, lists, list);
            return lists;
        }

        private void backtrack(int[] nums, int begin, List<List<Integer>> lists, List<Integer> list) {
            lists.add(new ArrayList<>(list));

            for (int i = begin; i < nums.length; i++) {
                list.add(nums[i]);
                backtrack(nums, i + 1, lists, list);
                list.remove(list.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}