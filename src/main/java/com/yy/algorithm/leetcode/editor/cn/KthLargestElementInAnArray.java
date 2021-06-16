//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1132 👎 0

//frontendQuestionId:215

package com.yy.algorithm.leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            build(nums);
            for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
                shift(nums, 0, i);
            }
            return nums[0];
        }

        private int[] build(int[] nums) {
            for (int i = nums.length / 2; i >= 0; i--) {
                shift(nums, i, nums.length);
            }
            return nums;
        }

        private void shift(int[] nums, int index, int length) {
            int l = index * 2 + 1;
            int r = l + 1;
            int largest = index;
            if (l < length && nums[l] > nums[largest]) {
                largest = l;
            }
            if (r < length && nums[r] > nums[largest]) {
                largest = r;
            }
            if (largest != index) {
                int temp = nums[index];
                nums[index] = nums[largest];
                nums[largest] = temp;
                shift(nums, largest, length);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}