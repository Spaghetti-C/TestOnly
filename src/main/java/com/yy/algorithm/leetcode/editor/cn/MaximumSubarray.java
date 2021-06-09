//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：-1
// 
//
// 示例 5： 
//
// 
//输入：nums = [-100000]
//输出：-100000
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 3286 👎 0

//frontendQuestionId:53

package com.yy.algorithm.leetcode.editor.cn;

public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumSubarray().new Solution();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution.maxSubArray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
//            return solution1(nums);
            return solution2(nums);
        }

        // 动态规划
        private int solution1(int[] nums) {
            int max = Integer.MIN_VALUE;
            int length = nums.length;
            int sum = 0;
            for (int i = 0; i < length; i++) {
                sum += nums[i];
                max = Math.max(max, sum);
                if (sum < 0) {
                    sum = 0;
                }
            }

            return max;
        }

        // 分治法
        private int solution2(int[] nums) {
            return recursion(nums, 0, nums.length - 1);
        }

        private int recursion(int[] nums, int left, int right) {
            if (left > right) {
                return Integer.MIN_VALUE;
            }
            int middle = (left + right) / 2;
            int leftValue = recursion(nums, left, middle - 1);
            int rightValue = recursion(nums, middle + 1, right);

            int sum = 0;
            int leftSum = 0;
            for (int i = middle - 1; i >= left; i--) {
                sum += nums[i];
                leftSum = Math.max(leftSum, sum);
            }
            sum = 0;
            int rightSum = 0;
            for (int i = middle + 1; i <= right; i++) {
                sum += nums[i];
                rightSum = Math.max(rightSum, sum);
            }

            return Math.max(Math.max(leftValue, rightValue), nums[middle] + leftSum + rightSum);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}