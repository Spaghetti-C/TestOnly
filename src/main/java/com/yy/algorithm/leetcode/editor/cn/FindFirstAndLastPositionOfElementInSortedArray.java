//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1031 👎 0

//frontendQuestionId:34

package com.yy.algorithm.leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[] nums = {1, 2, 3, 3, 3, 3, 4, 5, 9};
        System.out.println(solution.searchRange(nums, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int length = nums.length;
            int left = 0;
            int right = length - 1;
            int[] res = new int[2];
            int middle = 0;

            while (left <= right) {
                middle = (left + right) / 2;
                if (nums[middle] == target) {
                    break;
                }
                if (nums[middle] < target) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            if (left > right) {
                res[0] = -1;
                res[1] = -1;
                return res;
            } else {
                left = middle;
                right = middle;
                for (int i = left - 1; i >= 0; i--) {
                    if (nums[i] == target) {
                        left = i;
                        continue;
                    }
                    break;
                }
                for (int i = right + 1; i < length; i++) {
                    if (nums[i] == target) {
                        right = i;
                        continue;
                    }
                    break;
                }

            }
            res[0] = left;
            res[1] = right;
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}