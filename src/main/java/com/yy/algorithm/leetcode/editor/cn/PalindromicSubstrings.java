//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 614 👎 0

//frontendQuestionId:647

package com.yy.algorithm.leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
        String s = "abc";
        solution.countSubstrings(s);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings(String s) {
            int res = 0;
            // 初始化字符串
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                sb.append("#");
                sb.append(s.charAt(i));
            }
            sb.append("#");
            s = sb.toString();
            int length = s.length();

            int[] radius = new int[length];
            int r = -1;
            int c = -1;
            for (int i = 0; i < length; i++) {
                // 初始化半径
                radius[i] = r > i ? Math.min(radius[2 * c - i], r - i) : 0;

                // 中心扩展
                while (i + radius[i] + 1 < length && i - radius[i] - 1 >= 0) {
                    if (s.charAt(i + radius[i] + 1) == s.charAt(i - radius[i] - 1)) {
                        radius[i]++;
                    } else {
                        break;
                    }
                }

                // 维护对称中心和最右边界
                if (i + radius[i] > r) {
                    r = i + radius[i];
                    c = i;
                }

                // 更新结果
                res += (radius[i] + 1) / 2;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}