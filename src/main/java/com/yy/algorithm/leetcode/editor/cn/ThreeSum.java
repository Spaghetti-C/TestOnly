//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3371 👎 0

//frontendQuestionId:15

package com.yy.algorithm.leetcode.editor.cn;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            return solution(nums, 0);
        }

        // 夹逼法，外加重复元素跳过逻辑
        private List<List<Integer>> solution(int[] nums, int target) {
            List<List<Integer>> lists = new LinkedList<>();
            Arrays.sort(nums);
            int m = nums.length;
            for (int i = 0; i < m; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }

                int subTarget = target - nums[i];
                int j = i + 1;
                int k = m - 1;
                while (j < k) {
                    if (nums[j] + nums[k] == subTarget) {
                        LinkedList<Integer> list = new LinkedList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                        while (j < k && nums[j] == nums[j + 1]) {
                            j++;
                        }
                        while (j < k && nums[k] == nums[k - 1]) {
                            k--;
                        }
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] > subTarget) {
                        k--;
                    } else {
                        j++;
                    }

                }
            }

            return lists;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}