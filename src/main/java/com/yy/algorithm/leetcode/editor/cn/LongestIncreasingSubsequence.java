//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序
//列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以设计时间复杂度为 O(n2) 的解决方案吗？ 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 1674 👎 0

//frontendQuestionId:300

package com.yy.algorithm.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestIncreasingSubsequence().new Solution();
        int[] nums = {3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        System.out.println(solution.lengthOfLIS(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 使用递增栈
        public int lengthOfLIS(int[] nums) {
            int length = nums.length;
            if (length == 0) {
                return 0;
            }

            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            for (int i = 1; i < length; i++) {
                // 数组中数字都大于nums[i]则直接添加到数组
                if (nums[i] > list.get(list.size() - 1)) {
                    list.add(nums[i]);
                } else {
                    int l = 0;
                    int r = list.size() - 1;
                    int index = 0;
                    // 找到下标最小的大于nums[i]的数，进行替换
                    while (l <= r) {
                        int middle = (l + r) / 2;
                        if (nums[i] > list.get(middle)) {
                            l = middle + 1;
                        } else {
                            index = middle;
                            r = middle - 1;
                        }
                    }
                    list.set(index, nums[i]);
                }
            }
            return list.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}