//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[0]
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
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以不使用代码库中的排序函数来解决这道题吗？ 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
// Related Topics 排序 数组 双指针 
// 👍 908 👎 0

//frontendQuestionId:75

package com.yy.algorithm.leetcode.editor.cn;

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] nums = {1, 2, 0};
        solution.sortColors(nums);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
//            solution1(nums);
            solution2(nums);
        }

        private void solution1(int[] nums) {
            int a = 0;
            int b = 0;
            int c = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[a] = 2;
                    a++;
                    nums[b] = 1;
                    b++;
                    nums[c] = 0;
                    c++;
                } else if (nums[i] == 1) {
                    nums[a] = 2;
                    a++;
                    nums[b] = 1;
                    b++;
                } else {
                    nums[a] = 2;
                    a++;
                }
            }
        }

        // 挡板法
        private void solution2(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            int current = 0;

            while (current <= right) {
                if (nums[current] == 2) {
                    int temp = nums[current];
                    nums[current] = nums[right];
                    nums[right] = temp;
                    right--;
                } else if (nums[current] == 0) {
                    int temp = nums[current];
                    nums[current] = nums[left];
                    nums[left] = temp;
                    left++;
                    current++;
                } else {
                    current++;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}