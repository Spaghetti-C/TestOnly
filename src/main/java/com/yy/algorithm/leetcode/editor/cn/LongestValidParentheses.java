//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 字符串 动态规划 
// 👍 1316 👎 0

//frontendQuestionId:32

package com.yy.algorithm.leetcode.editor.cn;

import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new LongestValidParentheses().new Solution();
        System.out.println(solution.longestValidParentheses("()(())"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 栈
        public int longestValidParentheses(String s) {
//            return solution(s);
            return solution2(s);
        }

        public int solution(String s) {
            Stack<Integer> stack = new Stack<>();
            int res = 0;
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ')' && stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    res = Math.max(res, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
            return res;
        }

        // 动规
        public int solution2(String s) {
            int[] dp = new int[s.length() + 1];
            int res = 0;

            for (int i = 1; i <= s.length(); i++) {
                if (s.charAt(i - 1) == ')') {
                    if (i - 2 - dp[i - 1] >= 0 && s.charAt(i - 2 - dp[i - 1]) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        dp[i] = dp[i] + dp[i - dp[i]];
                        res = Math.max(res, dp[i]);
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}