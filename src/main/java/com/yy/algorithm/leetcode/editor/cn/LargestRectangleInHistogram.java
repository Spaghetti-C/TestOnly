//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 1386 👎 0

//frontendQuestionId:84

package com.yy.algorithm.leetcode.editor.cn;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        solution.largestRectangleArea(heights);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestRectangleArea(int[] heights) {
            // 增加哨兵
            int[] newHeights = new int[heights.length + 2];
            newHeights[0] = 0;
            newHeights[newHeights.length - 1] = 0;
            for (int i = 0; i < heights.length; i++) {
                newHeights[i + 1] = heights[i];
            }
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            for (int i = 0; i < newHeights.length; i++) {
                while (!stack.empty() && newHeights[stack.peek()] > newHeights[i]) {
                    int height = newHeights[stack.pop()];
                    int width = i - stack.peek() - 1;
                    res = Math.max(res, height * width);
                }

                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}