//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 553 👎 0

//frontendQuestionId:581

package com.yy.algorithm.leetcode.editor.cn;

import java.util.Stack;

public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(solution.findUnsortedSubarray(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int l = Integer.MAX_VALUE;
            int r = Integer.MIN_VALUE;
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 1; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                    l = Math.min(l, stack.pop());
                }
                if (l == 0) {
                    break;
                }
                stack.push(i);
            }
            stack.clear();
            stack.push(nums.length - 1);
            for (int i = nums.length - 2; i >= 0; i--) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    r = Math.max(r, stack.pop());
                }
                if (r == nums.length - 1) {
                    break;
                }
                stack.push(i);
            }

            return l < r ? r - l + 1 : 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}