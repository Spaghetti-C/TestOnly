//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1801 👎 0

//frontendQuestionId:22

package com.yy.algorithm.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> list = new LinkedList<>();
            backtrack(n, n, list, "");
            return list;
        }

        private void backtrack(int l, int r, List<String> list, String res) {
            if (l <= 0 && r <= 0) {
                list.add(res);
                return;
            }
            if (l > r) {
                return;
            }

            if (l > 0) {
                backtrack(l - 1, r, list, res + "(");
            }
            if (r > 0) {
                backtrack(l, r - 1, list, res + ")");
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}