//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1392 👎 0

//frontendQuestionId:46

package com.yy.algorithm.leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Permutations {
    public static void main(String[] args) {
        Solution solution = new Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            Map<Integer, Boolean> map = new HashMap<>();
            List<Integer> list = new LinkedList<>();
            List<List<Integer>> lists = new LinkedList<>();
            backtrack(nums, list, lists, map);
            return lists;
        }

        private void backtrack(int[] nums, List<Integer> list, List<List<Integer>> lists, Map<Integer, Boolean> map) {
            if (list.size() == nums.length) {
                lists.add(new LinkedList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (map.getOrDefault(nums[i], false)) {
                    continue;
                }
                map.put(nums[i], true);
                list.add(nums[i]);
                backtrack(nums, list, lists, map);
                map.put(nums[i], false);
                list.remove(new Integer(nums[i]));
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}