//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 数组 单调栈 
// 👍 789 👎 0

//frontendQuestionId:739

package com.yy.algorithm.leetcode.editor.cn;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new DailyTemperatures().new Solution();
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};
        solution.dailyTemperatures(temperatures);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 单调栈
        public int[] dailyTemperatures(int[] temperatures) {
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[temperatures.length];
            for (int i = temperatures.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && temperatures[stack.peek()] > temperatures[i]) {
                    res[i] = stack.peek() - i;
                } else {
                    res[i] = 0;
                }
                stack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}