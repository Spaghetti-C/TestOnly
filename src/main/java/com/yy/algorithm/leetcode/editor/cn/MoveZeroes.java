//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1099 👎 0

//frontendQuestionId:283

package com.yy.algorithm.leetcode.editor.cn;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void moveZeroes(int[] nums) {
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                if (nums[i] == 0) {
                    for (int j = i + 1; j < length; j++) {
                        if (nums[j] != 0) {
                            int temp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = temp;
                            break;
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}