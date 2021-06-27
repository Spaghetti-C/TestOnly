//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1133 👎 0

//frontendQuestionId:31

package com.yy.algorithm.leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
        int[] nums = {1, 1, 3, 2, 2};
        solution.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void nextPermutation(int[] nums) {
            int n = nums.length;
            int base;
            // 尾部寻找首个不递减元素
            for (base = n - 2; base >= 0; base--) {
                if (nums[base] < nums[base + 1]) {
                    break;
                }
            }

            // 找到比不递减元素大的元素进行交换
            if (base > -1) {
                for (int i = n - 1; i >= 0; i--) {
                    if (nums[i] > nums[base]) {
                        nums[i] = nums[base] ^ nums[i];
                        nums[base] = nums[i] ^ nums[base];
                        nums[i] = nums[i] ^ nums[base];
                        break;
                    }
                }
            }

            // 不递减元素后的所有元素逆序
            int left = base + 1;
            int right = n - 1;
            while (left < right) {
                nums[left] = nums[left] ^ nums[right];
                nums[right] = nums[left] ^ nums[right];
                nums[left] = nums[left] ^ nums[right];
                left++;
                right--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}