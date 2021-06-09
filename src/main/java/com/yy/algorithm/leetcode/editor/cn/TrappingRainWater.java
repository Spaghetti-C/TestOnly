//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2377 👎 0

//frontendQuestionId:42

package com.yy.algorithm.leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new TrappingRainWater().new Solution();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(solution.trap(height));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
//            return solution1(height);
//            return solution2(height);
            return solution3(height);
        }

        // 动态规划
        private int solution1(int[] height) {
            int length = height.length;
            int[] leftMax = new int[length];
            int[] rightMax = new int[length];
            int max = 0;
            int res = 0;
            for (int i = 0; i < length; i++) {
                if (height[i] > max) {
                    max = height[i];
                }
                leftMax[i] = max;
            }

            max = 0;
            for (int i = length - 1; i >= 0; i--) {
                if (height[i] > max) {
                    max = height[i];
                }
                rightMax[i] = max;
            }

            for (int i = 0; i < length; i++) {
                res += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return res;
        }

        // 双指针
        private int solution2(int[] height) {
            int length = height.length;
            int left = 0;
            int right = length - 1;
            int lMax = 0;
            int rMax = 0;
            int res = 0;

            while (left <= right) {
                if (height[left] < height[right]) {
                    if (height[left] < lMax) {
                        res += lMax - height[left];
                    } else {
                        lMax = height[left];
                    }
                    left++;
                } else {
                    if (height[right] < rMax) {
                        res += rMax - height[right];
                    } else {
                        rMax = height[right];
                    }
                    right--;
                }
            }

            return res;
        }

        // 单调栈
        private int solution3(int[] height) {
            Stack<Integer> stack = new Stack<>();
            int length = height.length;
            int res = 0;

            for (int i = 0; i < length; i++) {
                while (!stack.empty() && height[stack.peek()] < height[i]) {
                    int top = stack.pop();
                    if (stack.empty()) {
                        break;
                    }
                    int left = stack.peek();
                    int currentWidth = i - left - 1;
                    int currentHeight = Math.min(height[left], height[i]) - height[top];
                    res += currentHeight * currentWidth;
                }

                stack.push(i);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}