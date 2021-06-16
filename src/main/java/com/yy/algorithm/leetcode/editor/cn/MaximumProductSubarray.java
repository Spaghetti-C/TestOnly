//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1135 👎 0

//frontendQuestionId:152

package com.yy.algorithm.leetcode.editor.cn;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        int[] nums = {2, 3, -2, 4};
        System.out.println(solution.maxProduct(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int length = nums.length;
            int res = nums[0];
            int max = nums[0];
            int min = nums[0];
            for (int i = 1; i < length; i++) {
                int preMax = max;
                int preMin = min;
                max = Math.max(preMax * nums[i], Math.max(preMin * nums[i], nums[i]));
                min = Math.min(preMin * nums[i], Math.min(preMax * nums[i], nums[i]));
                res = Math.max(res, max);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}